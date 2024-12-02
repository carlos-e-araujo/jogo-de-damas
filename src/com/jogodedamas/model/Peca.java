package com.jogodedamas.model;

public abstract class Peca {
    protected char cor;
    protected Posicao posicao;

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

    @Override
    public String toString() {
        return String.valueOf(cor);
    }
}
