package menu;

import gerenciamento.GerenciadorGrafo;
import gerenciamento.OperacoesGrafo;
import representacao.ListaAdjacencia;
import resultados.ResultadoBusca;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

    private GerenciadorGrafo gerenciador;

    private OperacoesGrafo operacoes;

    public MenuPrincipal() {

        gerenciador =
                new GerenciadorGrafo();

        operacoes =
                new OperacoesGrafo(
                        gerenciador);
    }

    public void iniciar() {

        Scanner scanner =
                new Scanner(System.in);

        int opcao;

        do {

            mostrarMenu();

            opcao =
                    scanner.nextInt();

            if (!gerenciador.isGrafoCarregado()
                    && opcao != 1
                    && opcao != 0) {

                System.out.println();

                System.out.println(
                        "Nenhum grafo foi carregado.");

                System.out.println(
                        "Carregue um grafo antes de continuar.");

                carregarGrafo(scanner);

            } else {

                switch (opcao) {

                    case 1:
                        carregarGrafo(scanner);
                        break;

                    case 2:
                        escolherRepresentacao(scanner);
                        break;

                    case 3:
                        mostrarInformacoes();
                        break;

                    case 4:
                        executarBFS(scanner);
                        break;

                    case 5:
                        executarDFS(scanner);
                        break;

                    case 6:
                        calcularDistancia(scanner);
                        break;

                    case 7:
                        mostrarComponentes();
                        break;

                    case 8:
                        calcularDiametro();
                        break;

                    case 9:
                        compararDesempenho();
                        break;

                    case 0:

                        System.out.println();

                        System.out.println(
                                "Programa encerrado.");

                        break;

                    default:

                        System.out.println();

                        System.out.println(
                                "Opcao invalida.");
                }
            }

        } while (opcao != 0);

        scanner.close();
    }

    private void mostrarMenu() {

        System.out.println();

        System.out.println(
                "========================================");

        System.out.println(
                "          BIBLIOTECA DE GRAFOS");

        System.out.println(
                "========================================");

        if (gerenciador.isGrafoCarregado()) {

            System.out.println(
                    "Grafo: "
                            + gerenciador
                            .getArquivoAtual());

            if (gerenciador.getRepresentacao()
                    == 1) {

                System.out.println(
                        "Representacao: "
                                + "Lista de adjacencia");

            } else {

                System.out.println(
                        "Representacao: "
                                + "Matriz de adjacencia");
            }

        } else {

            System.out.println(
                    "Grafo: nenhum grafo carregado");
        }

        System.out.println();

        System.out.println(
                "1 - Carregar grafo");

        System.out.println(
                "2 - Escolher representacao");

        System.out.println(
                "3 - Informacoes do grafo");

        System.out.println(
                "4 - Busca em largura");

        System.out.println(
                "5 - Busca em profundidade");

        System.out.println(
                "6 - Distancia entre vertices");

        System.out.println(
                "7 - Componentes conexas");

        System.out.println(
                "8 - Diametro");

        System.out.println(
                "9 - Comparar desempenho");

        System.out.println(
                "0 - Sair");

        System.out.println();

        System.out.print(
                "Escolha: ");
    }

    private void carregarGrafo(
            Scanner scanner) {

        System.out.println();

        System.out.println(
                "========================================");

        System.out.println(
                "             ESCOLHA O GRAFO");

        System.out.println(
                "========================================");

        String[] arquivos =
                gerenciador.getArquivos();

        for (int i = 0;
             i < arquivos.length;
             i++) {

            System.out.println(
                    (i + 1)
                            + " - "
                            + arquivos[i]);
        }

        System.out.println(
                "0 - Voltar");

        System.out.println();

        System.out.print(
                "Escolha: ");

        int opcao =
                scanner.nextInt();

        if (opcao == 0) {
            return;
        }

        if (opcao < 1
                || opcao > arquivos.length) {

            System.out.println();

            System.out.println(
                    "Opcao invalida.");

            return;
        }

        String arquivo =
                arquivos[opcao - 1];

        gerenciador.carregarGrafo(
                arquivo);

        if (gerenciador.isGrafoCarregado()) {

            System.out.println();

            System.out.println(
                    "Grafo carregado com sucesso.");

            System.out.println(
                    "Arquivo: "
                            + gerenciador
                            .getArquivoAtual());

            System.out.println(
                    "Vertices: "
                            + gerenciador
                            .getLista()
                            .getQuantidadeVertices());

        } else {

            System.out.println();

            System.out.println(
                    "Nao foi possivel carregar o grafo.");
        }
    }

    private void escolherRepresentacao(
            Scanner scanner) {

        System.out.println();

        System.out.println(
                "========================================");

        System.out.println(
                "          REPRESENTACAO DO GRAFO");

        System.out.println(
                "========================================");

        System.out.println(
                "1 - Lista de adjacencia");

        System.out.println(
                "2 - Matriz de adjacencia");

        System.out.println(
                "0 - Voltar");

        System.out.println();

        System.out.print(
                "Escolha: ");

        int opcao =
                scanner.nextInt();

        if (opcao == 0) {
            return;
        }

        if (opcao == 1) {

            gerenciador.setRepresentacao(1);

            System.out.println();

            System.out.println(
                    "Representacao selecionada: "
                            + "Lista de adjacencia.");

        } else if (opcao == 2) {

            long memoriaNecessaria =
                    gerenciador
                            .getMemoriaNecessariaMatriz();

            long memoriaDisponivel =
                    gerenciador
                            .getMemoriaDisponivel();

            System.out.println();

            System.out.println(
                    "Vertices: "
                            + gerenciador
                            .getLista()
                            .getQuantidadeVertices());

            System.out.println(
                    "Memoria estimada para a matriz: "
                            + String.format(
                            "%.2f MB",
                            converterParaMB(
                                    memoriaNecessaria)));

            System.out.println(
                    "Memoria maxima do heap da JVM: "
                            + String.format(
                            "%.2f MB",
                            converterParaMB(
                                    memoriaDisponivel)));

            System.out.println();

            System.out.println(
                    "Verificando memoria para a matriz...");

            boolean carregou =
                    gerenciador
                            .carregarMatriz();

            if (carregou) {

                gerenciador.setRepresentacao(2);

                System.out.println();

                System.out.println(
                        "Matriz carregada com sucesso.");

                System.out.println(
                        "Representacao selecionada: "
                                + "Matriz de adjacencia.");

            } else {

                System.out.println();

                System.out.println(
                        "Nao foi possivel criar a matriz.");

                System.out.println(
                        "A memoria estimada necessaria "
                                + "e maior que a memoria maxima "
                                + "do heap da JVM.");

                System.out.println();

                System.out.println(
                        "A representacao atual continua "
                                + "sendo a lista de adjacencia.");
            }

        } else {

            System.out.println();

            System.out.println(
                    "Opcao invalida.");
        }
    }

    private double converterParaMB(
            long bytes) {

        return bytes
                / (1024.0 * 1024.0);
    }

    private void mostrarInformacoes() {

        ListaAdjacencia lista =
                gerenciador.getLista();

        System.out.println();

        System.out.println(
                "===== INFORMACOES DO GRAFO =====");

        System.out.println(
                "Vertices: "
                        + lista.getQuantidadeVertices());

        System.out.println(
                "Arestas: "
                        + lista.quantidadeArestas());

        System.out.println(
                "Grau minimo: "
                        + lista.grauMinimo());

        System.out.println(
                "Grau maximo: "
                        + lista.grauMaximo());

        System.out.println(
                "Grau medio: "
                        + lista.grauMedio());

        System.out.println(
                "Mediana dos graus: "
                        + lista.grauMediano());

        operacoes.salvarInformacoes();

        System.out.println();

        System.out.println(
                "Informacoes salvas em "
                        + "informacoes_grafo.txt");
    }

    private void executarBFS(
            Scanner scanner) {

        System.out.println();

        System.out.println(
                "===== BUSCA EM LARGURA =====");

        System.out.print(
                "Vertice inicial: ");

        int inicio =
                scanner.nextInt();

        ResultadoBusca resultado =
                operacoes.buscarLargura(
                        inicio);

        System.out.println();

        if (resultado != null) {

            System.out.println(
                    "Busca em largura realizada.");

            System.out.println(
                    "Resultado salvo em "
                            + "bfs_" + inicio + ".txt");

        } else {

            System.out.println(
                    "Nao foi possivel realizar a busca.");

            System.out.println(
                    "A matriz de adjacencia nao pode "
                            + "ser criada para este grafo.");
        }
    }

    private void executarDFS(
            Scanner scanner) {

        System.out.println();

        System.out.println(
                "===== BUSCA EM PROFUNDIDADE =====");

        System.out.print(
                "Vertice inicial: ");

        int inicio =
                scanner.nextInt();

        ResultadoBusca resultado =
                operacoes.buscarProfundidade(
                        inicio);

        System.out.println();

        if (resultado != null) {

            System.out.println(
                    "Busca em profundidade realizada.");

            System.out.println(
                    "Resultado salvo em "
                            + "dfs_" + inicio + ".txt");

        } else {

            System.out.println(
                    "Nao foi possivel realizar a busca.");

            System.out.println(
                    "A matriz de adjacencia nao pode "
                            + "ser criada para este grafo.");
        }
    }

    private void calcularDistancia(
            Scanner scanner) {

        System.out.println();

        System.out.println(
                "===== DISTANCIA =====");

        System.out.print(
                "Vertice de origem: ");

        int origem =
                scanner.nextInt();

        System.out.print(
                "Vertice de destino: ");

        int destino =
                scanner.nextInt();

        int distancia =
                operacoes.distancia(
                        origem,
                        destino);

        System.out.println();

        System.out.println(
                "Distancia: "
                        + distancia);
    }

    private void mostrarComponentes() {

        System.out.println();

        System.out.println(
                "===== COMPONENTES CONEXAS =====");

        ArrayList<ArrayList<Integer>>
                resultado =
                operacoes.componentesConexas();

        System.out.println();

        System.out.println(
                "Quantidade de componentes: "
                        + resultado.size());

        for (int i = 0;
             i < resultado.size();
             i++) {

            System.out.println();

            System.out.println(
                    "Componente "
                            + (i + 1));

            System.out.println(
                    "Tamanho: "
                            + resultado
                            .get(i)
                            .size());

            System.out.println(
                    "Vertices: "
                            + resultado.get(i));
        }

        System.out.println();

        System.out.println(
                "Componentes salvas em "
                        + "componentes.txt");
    }

    private void calcularDiametro() {

        System.out.println();

        System.out.println(
                "===== DIAMETRO =====");

        int resultado =
                operacoes.calcularDiametro();

        System.out.println();

        System.out.println(
                "Diametro: "
                        + resultado);
    }

    private void compararDesempenho() {

        System.out.println();

        System.out.println(
                "===== DESEMPENHO =====");

        System.out.println();

        System.out.println(
                "Executando 100 BFS e 100 DFS...");

        double[] resultados =
                operacoes.compararDesempenho();

        System.out.println();

        System.out.println(
                "BFS - Lista: "
                        + String.format(
                        "%.6f ms",
                        resultados[0]));

        System.out.println(
                "BFS - Matriz: "
                        + String.format(
                        "%.6f ms",
                        resultados[1]));

        System.out.println();

        System.out.println(
                "DFS - Lista: "
                        + String.format(
                        "%.6f ms",
                        resultados[2]));

        System.out.println(
                "DFS - Matriz: "
                        + String.format(
                        "%.6f ms",
                        resultados[3]));
    }
}