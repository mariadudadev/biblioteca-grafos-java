package representacao;

import java.util.ArrayList;
import java.util.Collections;

public class ListaAdjacencia {
    private ArrayList<ArrayList<Integer>> lista;

    public ListaAdjacencia(int quantidadeVertices) {
        lista = new ArrayList<>();

        for (int i = 0; i <= quantidadeVertices; i++) {
            lista.add(new ArrayList<>());
        }
    }

    public int getQuantidadeVertices() {
        return lista.size() - 1;
    }

    public ArrayList<Integer> vizinhos(int vertice) {
        return lista.get(vertice);
    }

    public int grau(int vertice) {
        return lista.get(vertice).size();
    }

    public int grauMinimo() {

        int menor = lista.get(1).size();

        for (int i = 2; i < lista.size(); i++) {

            if (lista.get(i).size() < menor) {
                menor = lista.get(i).size();
            }
        }

        return menor;
    }

    public int grauMaximo() {

        int maior = lista.get(1).size();

        for (int i = 2; i < lista.size(); i++) {

            if (lista.get(i).size() > maior) {
                maior = lista.get(i).size();
            }
        }

        return maior;
    }
    public ArrayList<Integer> todosOsGraus() {

        ArrayList<Integer> graus = new ArrayList<>();

        for (int i = 1; i < lista.size(); i++) {
            graus.add(lista.get(i).size());
        }

        return graus;
    }

    public int somaGraus() {

        int soma = 0;

        for (int i = 1; i < lista.size(); i++) {
            soma = soma + lista.get(i).size();
        }

        return soma;
    }

    public double grauMedio() {

        return (double) somaGraus() / (lista.size() - 1);
    }

    public void adicionarAresta(int origem, int destino) {

        if (origem == destino) {
            return;
        }

        if (!lista.get(origem).contains(destino)) {
            lista.get(origem).add(destino);
            lista.get(destino).add(origem);
        }
    }

    public void mostrar() {

        for (int i = 1; i < lista.size(); i++) {

            System.out.print(i + ": ");

            for (int vizinho : lista.get(i)) {
                System.out.print(vizinho + " ");
            }

            System.out.println();
        }
    }

    public int quantidadeArestas() {
        return somaGraus() / 2;
    }

    public double grauMediano() {

        ArrayList<Integer> graus = todosOsGraus();

        Collections.sort(graus);

        int meio = graus.size() / 2;

        return (graus.get(meio - 1) + graus.get(meio)) / 2.0;
    }

    public int quantidadeArestasSemDuplicatas() {

        int quantidade = 0;

        for (int i = 1; i < lista.size(); i++) {

            for (int j : lista.get(i)) {

                if (i < j) {
                    quantidade++;
                }
            }
        }

        return quantidade;
    }
}
