package com.jogodedamas.celula;

import com.jogodedamas.cor.Cor;
import com.jogodedamas.peca.Peca;

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
