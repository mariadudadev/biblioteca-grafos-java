package testes;

import algoritmos.BuscaProfundidade;
import algoritmos.BuscaProfundidadeMatriz;
import arquivos.LeitorGrafo;
import representacao.ListaAdjacencia;
import representacao.MatrizAdjacencia;

public class TesteTempoDFS {

    public static void main(String[] args) {

        ListaAdjacencia lista = LeitorGrafo.ler("grafo_1.txt");
        MatrizAdjacencia matriz = LeitorGrafo.lerMatriz("grafo_1.txt");

        BuscaProfundidade dfsLista = new BuscaProfundidade(lista);
        BuscaProfundidadeMatriz dfsMatriz = new BuscaProfundidadeMatriz(matriz);

        int[] verticesIniciais = new int[100];

        for (int i = 0; i < 100; i++) {
            verticesIniciais[i] = i + 1;
        }

        long tempoLista = 0;
        long tempoMatriz = 0;

        for (int inicio : verticesIniciais) {

            long inicioLista = System.nanoTime();

            dfsLista.buscar(inicio);

            long fimLista = System.nanoTime();

            tempoLista = tempoLista + (fimLista - inicioLista);


            long inicioMatriz = System.nanoTime();

            dfsMatriz.buscar(inicio);

            long fimMatriz = System.nanoTime();

            tempoMatriz = tempoMatriz + (fimMatriz - inicioMatriz);
        }

        double mediaLista = (double) tempoLista / verticesIniciais.length;
        double mediaMatriz = (double) tempoMatriz / verticesIniciais.length;

        System.out.println("DFS - Lista");
        System.out.println("Tempo medio: " + mediaLista / 1_000_000 + " ms");

        System.out.println();

        System.out.println("DFS - Matriz");
        System.out.println("Tempo medio: " + mediaMatriz / 1_000_000 + " ms");
    }
}