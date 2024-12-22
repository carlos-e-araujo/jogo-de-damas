package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;

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
            for (int j = 0; j < super.getColunas(); j++) {
                if (super.getCelula(i, j).getCor() == Cor.PRETO) {
                    super.getCelula(i, j).setPeca(new Comum(Cor.BRANCO));
                }
            }
        }

        for (int i = super.getLinhas() - 1; i > (super.getLinhas() / 2); i--) {
            for (int j = 0; j < super.getColunas(); j++) {
                if (super.getCelula(i, j).getCor() == Cor.PRETO) {
                    super.getCelula(i, j).setPeca(new Comum(Cor.PRETO));
                }
            }
        }
    }

    public boolean verificarJogada(int linhaInicial, int colunaInicial, int linhaFinal, int colunaFinal,
                                   Cor corJogador) {
        if (!(linhaFinal >= 0 && linhaFinal < this.getLinhas() && colunaFinal >= 0 && colunaFinal < this.getColunas())) {
            return false;
        } else if (!(linhaInicial >= 0 && linhaInicial < this.getLinhas() && colunaInicial >= 0 && colunaInicial < this.getColunas())) {
            return false;
        } else if (this.getCelula(linhaInicial, colunaInicial).getPeca() == null) {
            return false;
        } else if (this.getCelula(linhaFinal, colunaFinal).getPeca() != null) {
            return false;
        } else if (this.getCelula(linhaFinal, colunaFinal).getCor() == Cor.BRANCO) {
            return false;
        } else if (this.getCelula(linhaInicial, colunaInicial).getCor() == Cor.BRANCO) {
            return false;
        } else return this.getCelula(linhaInicial, colunaInicial).getPeca().getCor() == corJogador;
    }

    public void moverPeca(int linhaInicial, int colunaInicial, int linhaFinal, int colunaFinal) {
        if ((this.getCelula(linhaInicial, colunaInicial).getPeca().getCor() == Cor.PRETO) && (linhaFinal == 0)) {
            this.setCelula(linhaFinal, colunaFinal, new Celula(Cor.PRETO, new Dama(Cor.PRETO)));
        } else if ((this.getCelula(linhaInicial, colunaInicial).getPeca().getCor() == Cor.BRANCO) && (linhaFinal == (this.getLinhas() - 1))) {
            this.setCelula(linhaFinal, colunaFinal, new Celula(Cor.PRETO, new Dama(Cor.BRANCO)));
        } else {
            this.setCelula(linhaFinal, colunaFinal, this.getCelula(linhaInicial, colunaInicial));
        }

        this.setCelula(linhaInicial, colunaInicial, new Celula(Cor.PRETO));
    }
}
