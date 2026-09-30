package saida;

import representacao.ListaAdjacencia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SaidaInformacoes {

    public static void salvar(
            String nomeArquivo,
            ListaAdjacencia lista,
            ArrayList<ArrayList<Integer>> componentes) {

        try {

            PrintWriter arquivo =
                    new PrintWriter(
                            new FileWriter(nomeArquivo));

            arquivo.println(
                    "===== INFORMACOES DO GRAFO =====");

            arquivo.println();

            arquivo.println(
                    "Vertices: "
                            + lista.getQuantidadeVertices());

            arquivo.println(
                    "Arestas: "
                            + lista.quantidadeArestas());

            arquivo.println(
                    "Grau minimo: "
                            + lista.grauMinimo());

            arquivo.println(
                    "Grau maximo: "
                            + lista.grauMaximo());

            arquivo.println(
                    "Grau medio: "
                            + lista.grauMedio());

            arquivo.println(
                    "Grau mediano: "
                            + lista.grauMediano());

            arquivo.println();

            arquivo.println(
                    "===== COMPONENTES CONEXAS =====");

            arquivo.println();

            arquivo.println(
                    "Quantidade de componentes: "
                            + componentes.size());

            arquivo.println();

            for (int i = 0;
                 i < componentes.size();
                 i++) {

                ArrayList<Integer> componente =
                        componentes.get(i);

                arquivo.println(
                        "Componente "
                                + (i + 1));

                arquivo.println(
                        "Tamanho: "
                                + componente.size());

                arquivo.print(
                        "Vertices: ");

                for (int vertice : componente) {

                    arquivo.print(
                            vertice + " ");
                }

                arquivo.println();
                arquivo.println();
            }

            arquivo.close();

        } catch (IOException e) {

            System.out.println(
                    "Erro ao criar arquivo "
                            + nomeArquivo);
        }
    }
}