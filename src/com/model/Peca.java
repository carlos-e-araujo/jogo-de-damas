package com.model;

public abstract class Peca {
    private char cor;
    private Posicao posicao;

    public Peca(char cor, Posicao posicao) {
        this.cor = cor;
        this.posicao = posicao;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public char getCor() {
        return cor;
    }
}
