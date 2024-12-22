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

    public boolean verificarJogada(final Posicao origem, final Posicao destino, final Cor corJogador) {
        final Celula celulaOrigem = this.getCelula(origem.getLinha(), origem.getColuna());
        final Celula celulaDestino = this.getCelula(destino.getLinha(), destino.getColuna());

        if (!((destino.getLinha() >= 0) && (destino.getLinha() < this.getLinhas()) && (destino.getColuna() >= 0) && (destino.getColuna() < this.getColunas()))) {
            return false;
        }

        if (!((origem.getLinha() >= 0) && (origem.getLinha() < this.getLinhas()) && (origem.getColuna() >= 0) && (origem.getColuna() < this.getColunas()))) {
            return false;
        }

        if (celulaOrigem.getPeca() == null) {
            return false;
        }

        if (celulaDestino.getPeca() != null) {
            return false;
        }

        if (celulaOrigem.getCor() == Cor.BRANCO) {
            return false;
        }

        if (celulaDestino.getCor() == Cor.BRANCO) {
            return false;
        }

        return celulaOrigem.getPeca().getCor() == corJogador;
    }

    public void moverPeca(final Posicao origem, final Posicao destino) {
        final Celula celulaOrigem = this.getCelula(origem.getLinha(), origem.getColuna());
        final Celula celulaDestino = this.getCelula(destino.getLinha(), destino.getColuna());

        if (verificarPromocao(origem, destino)) {
            celulaDestino.setPeca(new Dama(celulaOrigem.getPeca().getCor()));
        } else {
            celulaDestino.setPeca(celulaOrigem.getPeca());
        }

        celulaOrigem.setPeca(null);
    }

    private boolean verificarPromocao(final Posicao origem, final Posicao destino) {
        final Celula celulaOrigem = this.getCelula(origem.getLinha(), origem.getColuna());

        if (celulaOrigem.getPeca().getCor() == Cor.PRETO) {
            return destino.getLinha() == 0;
        } else {
            return destino.getLinha() == (this.getLinhas() - 1);
        }
    }
}
