package com.jogodedamas.tabuleiro;

import com.jogodedamas.cor.Cor;
import com.jogodedamas.peca.Peca;
import com.jogodedamas.peca.comum.Comum;

public class Tabuleiro extends com.jogodetabuleiro.Tabuleiro<Peca> {

    private static final int DIMENSAO = 8;

    public Tabuleiro() {
        super(DIMENSAO, DIMENSAO);

        int buraco = 0;

        for (int i = 0; i < (super.getLinhas() / 2) - 1; i++) {
            for (int j = buraco; j < super.getColunas(); j += 2) {
                Comum comum = new Comum(Cor.BRANCO) {
                };
                super.setCelula(i, j, comum);
            }

            buraco = ((buraco == 0) ? 1 : 0);
        }

        for (int i = super.getLinhas() - 1; i > (super.getLinhas() / 2); i--) {
            for (int j = buraco; j < super.getColunas(); j += 2) {
                Comum comum = new Comum(Cor.PRETO);
                super.setCelula(i, j, comum);
            }

            buraco = ((buraco == 0) ? 1 : 0);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
