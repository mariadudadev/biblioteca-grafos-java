package algoritmos;

import representacao.MatrizAdjacencia;
import resultados.ResultadoBusca;

import java.util.LinkedList;
import java.util.Queue;

public class BuscaLarguraMatriz {

    private MatrizAdjacencia matriz;

    public BuscaLarguraMatriz(
            MatrizAdjacencia matriz) {

        this.matriz = matriz;
    }

    public ResultadoBusca buscar(int inicio) {

        int quantidadeVertices =
                matriz.getQuantidadeVertices();

        boolean[] visitado =
                new boolean[quantidadeVertices + 1];

        int[] pai =
                new int[quantidadeVertices + 1];

        int[] nivel =
                new int[quantidadeVertices + 1];

        Queue<Integer> fila =
                new LinkedList<>();

        fila.add(inicio);

        visitado[inicio] = true;

        nivel[inicio] = 0;

        while (!fila.isEmpty()) {

            int atual = fila.remove();

            for (int vizinho = 1;
                 vizinho <= quantidadeVertices;
                 vizinho++) {

                if (matriz.temAresta(
                        atual,
                        vizinho)
                        && !visitado[vizinho]) {

                    visitado[vizinho] = true;

                    pai[vizinho] = atual;

                    nivel[vizinho] =
                            nivel[atual] + 1;

                    fila.add(vizinho);
                }
            }
        }

        return new ResultadoBusca(
                pai,
                nivel);
    }
}