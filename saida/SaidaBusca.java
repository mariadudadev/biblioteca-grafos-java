package saida;

import resultados.ResultadoBusca;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaidaBusca {

    public static void salvar(
            String nomeArquivo,
            ResultadoBusca resultado,
            int quantidadeVertices) {

        try {

            PrintWriter arquivo =
                    new PrintWriter(
                            new FileWriter(nomeArquivo));

            int[] pai =
                    resultado.getPai();

            int[] nivel =
                    resultado.getNivel();

            arquivo.println(
                    "Vertice;Pai;Nivel");

            for (int i = 1;
                 i <= quantidadeVertices;
                 i++) {

                arquivo.println(
                        i + ";"
                                + pai[i] + ";"
                                + nivel[i]);
            }

            arquivo.close();

        } catch (IOException e) {

            System.out.println(
                    "Erro ao criar arquivo "
                            + nomeArquivo);
        }
    }
}