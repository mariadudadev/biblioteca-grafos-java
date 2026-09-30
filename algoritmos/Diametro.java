package algoritmos;
import representacao.ListaAdjacencia;

public class Diametro {

    private ListaAdjacencia lista;

    public Diametro(ListaAdjacencia lista) {
        this.lista = lista;
    }

    public int calcular() {

        BuscaLargura bfs = new BuscaLargura(lista);

        int maior = 0;

        for (int i = 1; i <= lista.getQuantidadeVertices(); i++) {

            int distancia = bfs.maiorDistancia(i);

            if (distancia > maior) {
                maior = distancia;
            }
        }

        return maior;
    }
}
