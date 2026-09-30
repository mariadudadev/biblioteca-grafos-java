package representacao;

public class MatrizAdjacencia {

    private boolean[][] matriz;

    public MatrizAdjacencia(int quantidadeVertices) {

        matriz = new boolean[quantidadeVertices + 1]
                [quantidadeVertices + 1];
    }

    public int getQuantidadeVertices() {

        return matriz.length - 1;
    }

    public void adicionarAresta(int origem, int destino) {

        if (origem == destino) {
            return;
        }

        matriz[origem][destino] = true;
        matriz[destino][origem] = true;
    }

    public boolean temAresta(int origem, int destino) {

        return matriz[origem][destino];
    }

    public void mostrar() {

        for (int i = 1; i < matriz.length; i++) {

            for (int j = 1; j < matriz.length; j++) {

                if (matriz[i][j]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }

            System.out.println();
        }
    }
}