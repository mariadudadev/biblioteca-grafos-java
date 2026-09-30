package gerenciamento;

import algoritmos.BuscaLargura;
import algoritmos.BuscaLarguraMatriz;
import algoritmos.BuscaProfundidade;
import algoritmos.BuscaProfundidadeMatriz;
import algoritmos.ComponentesConexas;
import algoritmos.Diametro;
import resultados.ResultadoBusca;
import saida.SaidaBusca;
import saida.SaidaComponentes;
import saida.SaidaInformacoes;

import java.util.ArrayList;

public class OperacoesGrafo {

    private GerenciadorGrafo gerenciador;

    public OperacoesGrafo(
            GerenciadorGrafo gerenciador) {

        this.gerenciador =
                gerenciador;
    }

    public ResultadoBusca buscarLargura(
            int inicio) {

        ResultadoBusca resultado;

        if (gerenciador.getRepresentacao()
                == 1) {

            BuscaLargura bfs =
                    new BuscaLargura(
                            gerenciador.getLista());

            resultado =
                    bfs.buscar(inicio);

        } else {

            if (gerenciador.getMatriz()
                    == null) {

                boolean carregou =
                        gerenciador
                                .carregarMatriz();

                if (!carregou) {
                    return null;
                }
            }

            BuscaLarguraMatriz bfs =
                    new BuscaLarguraMatriz(
                            gerenciador.getMatriz());

            resultado =
                    bfs.buscar(inicio);
        }

        String nomeArquivo =
                "bfs_" + inicio + ".txt";

        int quantidadeVertices =
                gerenciador.getLista()
                        .getQuantidadeVertices();

        SaidaBusca.salvar(
                nomeArquivo,
                resultado,
                quantidadeVertices);

        return resultado;
    }

    public ResultadoBusca buscarProfundidade(
            int inicio) {

        ResultadoBusca resultado;

        if (gerenciador.getRepresentacao()
                == 1) {

            BuscaProfundidade dfs =
                    new BuscaProfundidade(
                            gerenciador.getLista());

            resultado =
                    dfs.buscar(inicio);

        } else {

            if (gerenciador.getMatriz()
                    == null) {

                boolean carregou =
                        gerenciador
                                .carregarMatriz();

                if (!carregou) {
                    return null;
                }
            }

            BuscaProfundidadeMatriz dfs =
                    new BuscaProfundidadeMatriz(
                            gerenciador.getMatriz());

            resultado =
                    dfs.buscar(inicio);
        }

        String nomeArquivo =
                "dfs_" + inicio + ".txt";

        int quantidadeVertices =
                gerenciador.getLista()
                        .getQuantidadeVertices();

        SaidaBusca.salvar(
                nomeArquivo,
                resultado,
                quantidadeVertices);

        return resultado;
    }

    public int distancia(
            int origem,
            int destino) {

        // A distancia deve ser calculada
        // utilizando BFS, conforme o enunciado.

        BuscaLargura bfs =
                new BuscaLargura(
                        gerenciador.getLista());

        return bfs.distancia(
                origem,
                destino);
    }

    public ArrayList<ArrayList<Integer>>
    componentesConexas() {

        ComponentesConexas componentes =
                new ComponentesConexas(
                        gerenciador.getLista());

        ArrayList<ArrayList<Integer>>
                resultado =
                componentes.encontrar();

        SaidaComponentes.salvar(
                "componentes.txt",
                resultado);

        return resultado;
    }

    public int calcularDiametro() {

        Diametro diametro =
                new Diametro(
                        gerenciador.getLista());

        return diametro.calcular();
    }

    public void salvarInformacoes() {

        ComponentesConexas componentes =
                new ComponentesConexas(
                        gerenciador.getLista());

        ArrayList<ArrayList<Integer>>
                resultado =
                componentes.encontrar();

        SaidaInformacoes.salvar(
                "informacoes_grafo.txt",
                gerenciador.getLista(),
                resultado);
    }

    public double[] compararDesempenho() {

        int quantidadeExecucoes = 100;

        long inicioListaBFS =
                System.nanoTime();

        for (int i = 1;
             i <= quantidadeExecucoes;
             i++) {

            BuscaLargura bfs =
                    new BuscaLargura(
                            gerenciador.getLista());

            bfs.buscar(i);
        }

        long fimListaBFS =
                System.nanoTime();

        double mediaListaBFS =
                (fimListaBFS - inicioListaBFS)
                        / 1_000_000.0
                        / quantidadeExecucoes;


        if (gerenciador.getMatriz()
                == null) {

            gerenciador.carregarMatriz();
        }

        long inicioMatrizBFS =
                System.nanoTime();

        for (int i = 1;
             i <= quantidadeExecucoes;
             i++) {

            BuscaLarguraMatriz bfs =
                    new BuscaLarguraMatriz(
                            gerenciador.getMatriz());

            bfs.buscar(i);
        }

        long fimMatrizBFS =
                System.nanoTime();

        double mediaMatrizBFS =
                (fimMatrizBFS - inicioMatrizBFS)
                        / 1_000_000.0
                        / quantidadeExecucoes;


        long inicioListaDFS =
                System.nanoTime();

        for (int i = 1;
             i <= quantidadeExecucoes;
             i++) {

            BuscaProfundidade dfs =
                    new BuscaProfundidade(
                            gerenciador.getLista());

            dfs.buscar(i);
        }

        long fimListaDFS =
                System.nanoTime();

        double mediaListaDFS =
                (fimListaDFS - inicioListaDFS)
                        / 1_000_000.0
                        / quantidadeExecucoes;


        long inicioMatrizDFS =
                System.nanoTime();

        for (int i = 1;
             i <= quantidadeExecucoes;
             i++) {

            BuscaProfundidadeMatriz dfs =
                    new BuscaProfundidadeMatriz(
                            gerenciador.getMatriz());

            dfs.buscar(i);
        }

        long fimMatrizDFS =
                System.nanoTime();

        double mediaMatrizDFS =
                (fimMatrizDFS - inicioMatrizDFS)
                        / 1_000_000.0
                        / quantidadeExecucoes;


        return new double[] {
                mediaListaBFS,
                mediaMatrizBFS,
                mediaListaDFS,
                mediaMatrizDFS
        };
    }
}