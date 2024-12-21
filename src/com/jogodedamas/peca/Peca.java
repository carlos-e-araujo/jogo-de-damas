package com.jogodedamas.peca;

import com.jogodedamas.cor.Cor;

public class Peca {
    protected final Cor cor;

    public Peca(Cor cor) {
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return (cor == Cor.BRANCO ? "b" : "p");
    }
}
