package testes;

import algoritmos.BuscaProfundidade;
import arquivos.LeitorGrafo;
import representacao.ListaAdjacencia;
import resultados.ResultadoBusca;

public class TestePais {

    public static void main(String[] args) {

        ListaAdjacencia lista = LeitorGrafo.ler("grafo_1.txt");

        BuscaProfundidade dfs = new BuscaProfundidade(lista);

        int[] inicios = {1, 2, 3};
        int[] vertices = {10, 20, 30};

        System.out.println("DFS");
        System.out.println();

        for (int inicio : inicios) {

            ResultadoBusca resultado = dfs.buscar(inicio);

            int[] pai = resultado.getPai();

            System.out.println("Inicio: " + inicio);

            for (int vertice : vertices) {

                System.out.println(
                        "Vertice " + vertice +
                                " -> Pai: " + pai[vertice]
                );
            }

            System.out.println();
        }
    }
}