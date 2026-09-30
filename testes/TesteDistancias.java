package testes;

import algoritmos.BuscaLargura;
import arquivos.LeitorGrafo;
import representacao.ListaAdjacencia;

public class TesteDistancias {

    public static void main(String[] args) {

        ListaAdjacencia lista = LeitorGrafo.ler("grafo_1.txt");

        BuscaLargura bfs = new BuscaLargura(lista);

        int distancia10_20 = bfs.distancia(10, 20);
        int distancia10_30 = bfs.distancia(10, 30);
        int distancia20_30 = bfs.distancia(20, 30);

        System.out.println("Distancia 10-20: " + distancia10_20);
        System.out.println("Distancia 10-30: " + distancia10_30);
        System.out.println("Distancia 20-30: " + distancia20_30);
    }
}