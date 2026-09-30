package testes;

import algoritmos.ComponentesConexas;
import arquivos.LeitorGrafo;
import representacao.ListaAdjacencia;
import saida.SaidaComponentes;

import java.util.ArrayList;

public class TesteSaidaComponentes {

    public static void main(String[] args) {

        ListaAdjacencia lista = LeitorGrafo.ler("grafo_1.txt");

        ComponentesConexas componentesConexas =
                new ComponentesConexas(lista);

        ArrayList<ArrayList<Integer>> componentes =
                componentesConexas.encontrar();

        SaidaComponentes.salvar(
                "componentes.txt",
                componentes
        );

        System.out.println("Arquivo criado.");
    }
}