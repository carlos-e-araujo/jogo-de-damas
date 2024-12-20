package com.jogodedamas.tabuleiro;

import com.jogodedamas.celula.Celula;
import com.jogodedamas.cor.Cor;
import com.jogodedamas.peca.comum.Comum;

public class Tabuleiro extends com.jogodetabuleiro.Tabuleiro<Celula> {
    private static final int DIMENSAO = 8;

    public Tabuleiro() {
        super(DIMENSAO, DIMENSAO);

        for (int i = 0; i < DIMENSAO; i++) {
            Cor cor = ((i % 2) == 0) ? Cor.BRANCO : Cor.PRETO;

            for (int j = 0; j < DIMENSAO; j++) {
                this.setCelula(i, j, new Celula(cor));
                cor = (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
            }
        }

        for (int i = 0; i < (super.getLinhas() / 2) - 1; i++) {
            for (int j = 0; j < super.getColunas(); j ++) {
                if (super.getCelula(i, j).getCor() == Cor.PRETO) {
                    Comum comum = new Comum(Cor.BRANCO);
                    super.getCelula(i, j).setPeca(comum);
                }
            }
        }

        for (int i = super.getLinhas() - 1; i > (super.getLinhas() / 2); i--) {
            for (int j = 0; j < super.getColunas(); j ++) {
                if (super.getCelula(i, j).getCor() == Cor.PRETO) {
                    Comum comum = new Comum(Cor.PRETO);
                    super.getCelula(i, j).setPeca(comum);
                }
            }
        }
    }
}
