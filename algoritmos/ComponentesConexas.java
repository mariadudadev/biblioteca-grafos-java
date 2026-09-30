package algoritmos;

import representacao.ListaAdjacencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class ComponentesConexas {

    private ListaAdjacencia lista;

    public ComponentesConexas(ListaAdjacencia lista) {
        this.lista = lista;
    }

    public ArrayList<ArrayList<Integer>> encontrar() {

        int quantidadeVertices =
                lista.getQuantidadeVertices();

        boolean[] visitado =
                new boolean[quantidadeVertices + 1];

        ArrayList<ArrayList<Integer>> componentes =
                new ArrayList<>();

        for (int i = 1;
             i <= quantidadeVertices;
             i++) {

            if (!visitado[i]) {

                ArrayList<Integer> componente =
                        new ArrayList<>();

                Queue<Integer> fila =
                        new LinkedList<>();

                fila.add(i);
                visitado[i] = true;

                while (!fila.isEmpty()) {

                    int atual =
                            fila.remove();

                    componente.add(atual);

                    for (int vizinho :
                            lista.vizinhos(atual)) {

                        if (!visitado[vizinho]) {

                            visitado[vizinho] = true;
                            fila.add(vizinho);
                        }
                    }
                }

                componentes.add(componente);
            }
        }

        // Maior componente primeiro
        Collections.sort(
                componentes,
                new Comparator<ArrayList<Integer>>() {

                    @Override
                    public int compare(
                            ArrayList<Integer> a,
                            ArrayList<Integer> b) {

                        return Integer.compare(
                                b.size(),
                                a.size());
                    }
                });

        return componentes;
    }
}