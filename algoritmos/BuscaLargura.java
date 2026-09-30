package algoritmos;

import representacao.ListaAdjacencia;
import resultados.ResultadoBusca;

import java.util.*;

public class BuscaLargura {

    private ListaAdjacencia lista;

    public BuscaLargura(ListaAdjacencia lista) {
        this.lista = lista;
    }

    public int distancia(int origem, int destino) {

        ResultadoBusca resultado = buscar(origem);

        int[] nivel = resultado.getNivel();

        return nivel[destino];
    }

    public int maiorDistancia(int origem) {

        ResultadoBusca resultado = buscar(origem);

        int[] nivel = resultado.getNivel();

        int maior = 0;

        for (int i = 1; i < nivel.length; i++) {

            if (nivel[i] > maior) {
                maior = nivel[i];
            }
        }

        return maior;
    }

    public ResultadoBusca buscar(int inicio) {

        int quantidadeVertices = lista.getQuantidadeVertices();

        boolean[] visitado = new boolean[quantidadeVertices + 1];

        int[] pai = new int[quantidadeVertices + 1];

        int[] nivel = new int[quantidadeVertices + 1];

        Queue<Integer> fila = new LinkedList<>();
        fila.add(inicio);

        visitado[inicio] = true;
        nivel[inicio] = 0;

        while (!fila.isEmpty()) {
            int atual = fila.remove();
            for (int vizinho : lista.vizinhos(atual)) {
                if (!visitado[vizinho]) {

                    visitado[vizinho] = true;

                    pai[vizinho] = atual;

                    nivel[vizinho] = nivel[atual] + 1;

                    fila.add(vizinho);
                }
            }
        }
        return new ResultadoBusca(pai, nivel);
    }

}