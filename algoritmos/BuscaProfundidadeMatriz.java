package algoritmos;

import representacao.MatrizAdjacencia;
import resultados.ResultadoBusca;

public class BuscaProfundidadeMatriz {

    private MatrizAdjacencia matriz;

    private boolean[] visitado;

    private int[] pai;

    private int[] nivel;

    public BuscaProfundidadeMatriz(
            MatrizAdjacencia matriz) {

        this.matriz = matriz;
    }

    public ResultadoBusca buscar(int inicio) {

        int quantidadeVertices =
                matriz.getQuantidadeVertices();

        visitado =
                new boolean[quantidadeVertices + 1];

        pai =
                new int[quantidadeVertices + 1];

        nivel =
                new int[quantidadeVertices + 1];

        nivel[inicio] = 0;

        dfs(inicio);

        return new ResultadoBusca(
                pai,
                nivel);
    }

    private void dfs(int atual) {

        visitado[atual] = true;

        int quantidadeVertices =
                matriz.getQuantidadeVertices();

        for (int vizinho = 1;
             vizinho <= quantidadeVertices;
             vizinho++) {

            if (matriz.temAresta(
                    atual,
                    vizinho)
                    && !visitado[vizinho]) {

                pai[vizinho] = atual;

                nivel[vizinho] =
                        nivel[atual] + 1;

                dfs(vizinho);
            }
        }
    }
}