package saida;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SaidaComponentes {

    public static void salvar(
            String nomeArquivo,
            ArrayList<ArrayList<Integer>> componentes) {

        try {

            PrintWriter arquivo =
                    new PrintWriter(
                            new FileWriter(nomeArquivo));

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
                        "Componente " + (i + 1));

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