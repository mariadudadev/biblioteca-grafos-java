package gerenciamento;

import arquivos.LeitorGrafo;
import representacao.ListaAdjacencia;
import representacao.MatrizAdjacencia;

public class GerenciadorGrafo {

    private ListaAdjacencia lista;
    private MatrizAdjacencia matriz;

    private String arquivoAtual;

    private boolean grafoCarregado;

    private int representacao;

    private final String[] arquivos = {
            "grafo_1.txt",
            "grafo_2.txt",
            "grafo_3.txt",
            "grafo_4.txt",
            "grafo_5.txt",
            "grafo_6.txt"
    };

    public GerenciadorGrafo() {

        grafoCarregado = false;
        representacao = 1;
    }

    public String[] getArquivos() {
        return arquivos;
    }

    public void carregarGrafo(
            String nomeArquivo) {

        lista =
                LeitorGrafo.ler(nomeArquivo);

        matriz = null;

        if (lista != null) {

            arquivoAtual =
                    nomeArquivo;

            grafoCarregado =
                    true;

        } else {

            lista = null;
            matriz = null;
            arquivoAtual = null;
            grafoCarregado = false;
        }
    }

    public boolean carregarMatriz() {

        if (arquivoAtual == null) {
            return false;
        }

        int quantidadeVertices =
                lista.getQuantidadeVertices();

        long memoriaEstimada =
                estimarMemoriaMatriz(
                        quantidadeVertices);

        long memoriaDisponivel =
                Runtime.getRuntime()
                        .maxMemory();

        if (memoriaEstimada >
                memoriaDisponivel) {

            return false;
        }

        matriz =
                LeitorGrafo
                        .lerMatriz(
                                arquivoAtual);

        return matriz != null;
    }

    private long estimarMemoriaMatriz(
            int quantidadeVertices) {

        long quantidadePosicoes =
                (long) (quantidadeVertices + 1)
                        * (quantidadeVertices + 1);

        long bytesPorPosicao = 4;

        return quantidadePosicoes
                * bytesPorPosicao;
    }

    public long getMemoriaNecessariaMatriz() {

        int quantidadeVertices =
                lista.getQuantidadeVertices();

        return estimarMemoriaMatriz(
                quantidadeVertices);
    }

    public long getMemoriaDisponivel() {

        return Runtime.getRuntime()
                .maxMemory();
    }

    public boolean isGrafoCarregado() {
        return grafoCarregado;
    }

    public ListaAdjacencia getLista() {
        return lista;
    }

    public MatrizAdjacencia getMatriz() {
        return matriz;
    }

    public String getArquivoAtual() {
        return arquivoAtual;
    }

    public int getRepresentacao() {
        return representacao;
    }

    public void setRepresentacao(
            int representacao) {

        this.representacao =
                representacao;
    }
}
