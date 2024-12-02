package com.jogodedamas.model;

import com.jogodedamas.jogodetabuleiro.Tabuleiro;

public class TabuleiroDamas extends Tabuleiro<Peca> {

    public TabuleiroDamas() {
        super(8, 8);

        super.getColunas();

        int buraco = 0;

        for (int i = 0; i < (super.getLinhas() / 2) - 1; i++) {
            for (int j = buraco; j < super.getColunas(); j += 2) {
                Comum peca = new Comum('b', new Posicao(i, j));
                super.setCelula(i, j, peca);
            }

            buraco = ((buraco == 0) ? 1 : 0);
        }

        for (int i = super.getLinhas() - 1; i > (super.getLinhas() / 2); i--) {
            for (int j = buraco; j < super.getColunas(); j += 2) {
                Comum peca = new Comum('p', new Posicao(i, j));
                super.setCelula(i, j, peca);
            }

            buraco = ((buraco == 0) ? 1 : 0);
        }
    }

    public boolean verificarMovimento(Posicao posicao, Peca peca) {
        // TODO: verificarMovimento
        return false;
    }

    public boolean verificarCaptura(Posicao posicao) {
        // TODO: verificarCaptura
        return false;
    }

    public boolean verificarVitoria(char cor) {
        // TODO: verificarVitoria
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
