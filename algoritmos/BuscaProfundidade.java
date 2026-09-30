package algoritmos;

import representacao.ListaAdjacencia;
import resultados.ResultadoBusca;

import java.util.Stack;

public class BuscaProfundidade {

    private ListaAdjacencia lista;

    public BuscaProfundidade(ListaAdjacencia lista) {
        this.lista = lista;
    }

    public ResultadoBusca buscar(int inicio) {

        int quantidadeVertices = lista.getQuantidadeVertices();

        boolean[] visitado = new boolean[quantidadeVertices + 1];

        int[] pai = new int[quantidadeVertices + 1];

        int[] nivel = new int[quantidadeVertices + 1];

        Stack<Integer> pilha = new Stack<>();

        pilha.push(inicio);

        visitado[inicio] = true;

        nivel[inicio] = 0;

        while (!pilha.isEmpty()) {

            int atual = pilha.pop();

            for (int vizinho : lista.vizinhos(atual)) {

                if (!visitado[vizinho]) {

                    visitado[vizinho] = true;

                    pai[vizinho] = atual;

                    nivel[vizinho] = nivel[atual] + 1;

                    pilha.push(vizinho);
                }
            }
        }

        return new ResultadoBusca(pai, nivel);
    }
}