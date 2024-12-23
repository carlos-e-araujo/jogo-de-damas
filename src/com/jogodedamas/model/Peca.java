package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;

public class Peca {
    private final Cor cor;
    private final int passo;

    public Peca(Cor cor, int passo) {
        this.cor = cor;
        this.passo = passo;
    }

    public Cor getCor() {
        return cor;
    }

    public int getPasso() {
        return passo;
    }
}
