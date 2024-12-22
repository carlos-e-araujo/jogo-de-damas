package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;

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

    public boolean verificarJogada(Posicao posicaoInicial, Posicao posicaoFinal, Cor corJogador) {
        if (!(posicaoFinal.getLinha() >= 0 && posicaoFinal.getLinha() < this.getLinhas() && posicaoFinal.getColuna() >= 0 && posicaoFinal.getColuna() < this.getColunas())) {
            return false;
        } else if (!(posicaoInicial.getLinha() >= 0 && posicaoInicial.getLinha() < this.getLinhas() && posicaoInicial.getColuna() >= 0 && posicaoInicial.getColuna() < this.getColunas())) {
            return false;
        } else if (this.getCelula(posicaoInicial.getLinha(), posicaoInicial.getColuna()).getPeca() == null) {
            return false;
        } else if (this.getCelula(posicaoFinal.getLinha(), posicaoFinal.getColuna()).getPeca() != null) {
            return false;
        } else if (this.getCelula(posicaoFinal.getLinha(), posicaoFinal.getColuna()).getCor() == Cor.BRANCO) {
            return false;
        } else if (this.getCelula(posicaoInicial.getLinha(), posicaoInicial.getColuna()).getCor() == Cor.BRANCO) {
            return false;
        } else {
            return this.getCelula(posicaoInicial.getLinha(), posicaoInicial.getColuna()).getPeca().getCor() == corJogador;
        }
    }

    public void moverPeca(Posicao origem, Posicao destino) {
        if ((this.getCelula(origem.getLinha(), origem.getColuna()).getPeca().getCor() == Cor.PRETO) && (destino.getLinha() == 0)) {
            this.setCelula(destino.getLinha(), destino.getColuna(), new Celula(Cor.PRETO, new Dama(Cor.PRETO)));
        } else if ((this.getCelula(origem.getLinha(), origem.getColuna()).getPeca().getCor() == Cor.BRANCO) && (destino.getLinha() == (this.getLinhas() - 1))) {
            this.setCelula(destino.getLinha(), destino.getColuna(), new Celula(Cor.PRETO, new Dama(Cor.BRANCO)));
        } else {
            this.setCelula(destino.getLinha(), destino.getColuna(), this.getCelula(origem.getLinha(),
                origem.getColuna()));
        }

        this.setCelula(origem.getLinha(), origem.getColuna(), new Celula(Cor.PRETO));
    }
}
