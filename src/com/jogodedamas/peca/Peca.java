package com.jogodedamas.peca;

public class Peca {
    protected char cor;

    public Peca(char cor, int distanciaMaximaDeMovimento) {
        this.cor = cor;
    }

    public char getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return String.valueOf(cor);
    }
}
