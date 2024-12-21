package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;

public class Celula {
    private final Cor COR;
    private Peca peca;

    public Celula(Cor cor) {
        COR = cor;
        peca = null;
    }

    public Celula(Cor cor, Peca peca) {
        this.COR = cor;
        this.peca = peca;
    }

    public Cor getCor() {
        return this.COR;
    }

    public Peca getPeca() {
        return this.peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}
