package resultados;

public class ResultadoBusca {

    private int[] pai;
    private int[] nivel;

    public ResultadoBusca(int[] pai, int[] nivel) {
        this.pai = pai;
        this.nivel = nivel;
    }

    public int[] getPai() {
        return pai;
    }

    public int[] getNivel() {
        return nivel;
    }
}