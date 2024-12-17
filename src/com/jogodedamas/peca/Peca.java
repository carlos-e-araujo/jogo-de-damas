package com.jogodedamas.peca;

import com.jogodedamas.cor.Cor;

public class Peca {

    protected enum TIPO {
        COMUM, DAMA
    }

    private final Cor cor;
    protected TIPO tipo;

    public Peca(Cor cor, TIPO tipo) {
        this.cor = cor;
        this.tipo = tipo;
    }

    public Cor getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return (cor == Cor.BRANCO ? "b" : "p");
    }
}
