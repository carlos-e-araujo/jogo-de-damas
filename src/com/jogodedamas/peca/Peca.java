package com.jogodedamas.peca;

import com.jogodedamas.cor.COR;

public class Peca {

    protected enum TIPO {
        COMUM, DAMA
    }

    private final COR cor;
    protected TIPO tipo;

    public Peca(COR cor, TIPO tipo) {
        this.cor = cor;
        this.tipo = tipo;
    }

    public COR getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return (cor == COR.BRANCO ? "b" : "p");
    }
}
