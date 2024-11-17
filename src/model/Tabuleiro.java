package model;

public class Tabuleiro {
    private Peca[][] pecas;

    public Tabuleiro(Peca[][] pecas) {
        // TODO: Tabuleiro constructor
    }

    public boolean moverPeca(int inicioX, int inicioY, int fimX, int fimY) {
        // TODO: moverPeca
        return false;
    }

    public Peca obterPecaEm(int x, int y) {
        // TODO: obterPecaEm
        return null;
    }

    public void verificarPossiveisDamas() {
        // TODO: verificarPossiveisDamas
    }

    public boolean verificarVitoria() {
        // TODO: verificarVitoria
        return false;
    }

    public int verificarMaxCapturasPossiveis() {
        // TODO: verificarMaxCapturasPossiveis
        return 0;
    }

    public Peca[][] getPecas() {
        return pecas;
    }

    public void setPecas(Peca[][] pecas) {
        this.pecas = pecas;
    }
}
