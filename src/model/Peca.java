package model;

public class Peca {
    private char cor;
    private boolean isDama;
    private Posicao posicao;

    public Peca(char cor, Posicao posicao) {
        this.cor = cor;
        this.posicao = posicao;
        this.isDama = false;
    }

    public void promoverParaDama() {
        // TODO: promoverParaDama
    }

    // Getters and Setters
    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public char getCor() {
        return cor;
    }

    public boolean isDama() {
        return isDama;
    }
}
