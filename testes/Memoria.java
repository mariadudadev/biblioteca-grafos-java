package testes;

import arquivos.LeitorGrafo;
import representacao.ListaAdjacencia;
import representacao.MatrizAdjacencia;

public class Memoria {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        System.gc();

        long memoriaAntesLista =
                runtime.totalMemory() - runtime.freeMemory();

        ListaAdjacencia lista =
                LeitorGrafo.ler("grafo_1.txt");

        System.gc();

        long memoriaDepoisLista =
                runtime.totalMemory() - runtime.freeMemory();

        long memoriaLista =
                memoriaDepoisLista - memoriaAntesLista;

        System.out.println("testes.Memoria aproximada da lista: "
                + memoriaLista / (1024.0 * 1024.0) + " MB");

        lista = null;

        System.gc();

        long memoriaAntesMatriz =
                runtime.totalMemory() - runtime.freeMemory();

        MatrizAdjacencia matriz =
                LeitorGrafo.lerMatriz("grafo_1.txt");

        System.gc();

        long memoriaDepoisMatriz =
                runtime.totalMemory() - runtime.freeMemory();

        long memoriaMatriz =
                memoriaDepoisMatriz - memoriaAntesMatriz;

        System.out.println("testes.Memoria aproximada da matriz: "
                + memoriaMatriz / (1024.0 * 1024.0) + " MB");
    }
}