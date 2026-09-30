package testes;

import algoritmos.ComponentesConexas;
import arquivos.LeitorGrafo;
import representacao.ListaAdjacencia;

import java.util.ArrayList;

public class TesteComponentes {

    public static void main(String[] args) {

        ListaAdjacencia lista = LeitorGrafo.ler("grafo_1.txt");

        ComponentesConexas componentesConexas =
                new ComponentesConexas(lista);

        ArrayList<ArrayList<Integer>> componentes =
                componentesConexas.encontrar();

        System.out.println("Quantidade de componentes: "
                + componentes.size());

        int maior = componentes.get(0).size();
        int menor = componentes.get(0).size();

        for (int i = 0; i < componentes.size(); i++) {

            ArrayList<Integer> componente = componentes.get(i);

            System.out.println(
                    "Componente " + (i + 1) +
                            " - tamanho: " + componente.size()
            );

            if (componente.size() > maior) {
                maior = componente.size();
            }

            if (componente.size() < menor) {
                menor = componente.size();
            }
        }

        System.out.println();
        System.out.println("Maior componente: " + maior);
        System.out.println("Menor componente: " + menor);
    }
}