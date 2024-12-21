package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;

public class Celula {
    private final Cor COR;
    private Peca peca;

    public Celula(Cor cor) {
        COR = cor;
        peca = null;
    }

    public Cor getCor() {
        return COR;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}
