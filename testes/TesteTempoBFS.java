package testes;

import algoritmos.BuscaLargura;
import algoritmos.BuscaLarguraMatriz;
import arquivos.LeitorGrafo;
import representacao.ListaAdjacencia;
import representacao.MatrizAdjacencia;

public class TesteTempoBFS {

    public static void main(String[] args) {

        ListaAdjacencia lista = LeitorGrafo.ler("grafo_1.txt");
        MatrizAdjacencia matriz = LeitorGrafo.lerMatriz("grafo_1.txt");

        BuscaLargura bfsLista = new BuscaLargura(lista);
        BuscaLarguraMatriz bfsMatriz = new BuscaLarguraMatriz(matriz);

        int[] verticesIniciais = new int[100];

        for (int i = 0; i < 100; i++) {
            verticesIniciais[i] = i + 1;
        }

        long tempoLista = 0;
        long tempoMatriz = 0;

        for (int inicio : verticesIniciais) {

            long inicioLista = System.nanoTime();

            bfsLista.buscar(inicio);

            long fimLista = System.nanoTime();

            tempoLista = tempoLista + (fimLista - inicioLista);


            long inicioMatriz = System.nanoTime();

            bfsMatriz.buscar(inicio);

            long fimMatriz = System.nanoTime();

            tempoMatriz = tempoMatriz + (fimMatriz - inicioMatriz);
        }

        double mediaLista = (double) tempoLista / verticesIniciais.length;
        double mediaMatriz = (double) tempoMatriz / verticesIniciais.length;

        System.out.println("BFS - Lista");
        System.out.println("Tempo medio: " + mediaLista / 1_000_000 + " ms");

        System.out.println();

        System.out.println("BFS - Matriz");
        System.out.println("Tempo medio: " + mediaMatriz / 1_000_000 + " ms");
    }
}