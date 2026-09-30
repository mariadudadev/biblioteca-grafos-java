package arquivos;

import representacao.ListaAdjacencia;
import representacao.MatrizAdjacencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorGrafo {

    public static ListaAdjacencia ler(
            String nomeArquivo) {

        try {

            Scanner scanner =
                    new Scanner(
                            new File(nomeArquivo));

            int quantidadeVertices =
                    scanner.nextInt();

            ListaAdjacencia lista =
                    new ListaAdjacencia(
                            quantidadeVertices);

            while (scanner.hasNextInt()) {

                int origem =
                        scanner.nextInt();

                int destino =
                        scanner.nextInt();

                lista.adicionarAresta(
                        origem,
                        destino);
            }

            scanner.close();

            return lista;

        } catch (FileNotFoundException e) {

            System.out.println(
                    "Arquivo nao encontrado.");

            return null;
        }
    }

    public static MatrizAdjacencia lerMatriz(
            String nomeArquivo) {

        try {

            Scanner scanner =
                    new Scanner(
                            new File(nomeArquivo));

            int quantidadeVertices =
                    scanner.nextInt();

            MatrizAdjacencia matriz =
                    new MatrizAdjacencia(
                            quantidadeVertices);

            while (scanner.hasNextInt()) {

                int origem =
                        scanner.nextInt();

                int destino =
                        scanner.nextInt();

                matriz.adicionarAresta(
                        origem,
                        destino);
            }

            scanner.close();

            return matriz;

        } catch (FileNotFoundException e) {

            System.out.println(
                    "Arquivo nao encontrado.");

            return null;
        }
    }
}