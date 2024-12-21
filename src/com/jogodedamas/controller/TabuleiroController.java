package com.jogodedamas.controller;

import com.jogodedamas.model.Celula;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.view.TabuleiroView;

public class TabuleiroController extends com.jogodetabuleiro.TabuleiroController<Celula> {
    public TabuleiroController(Tabuleiro tabuleiro, TabuleiroView<Celula> tabuleiroView) {
        super(tabuleiro, tabuleiroView);
    }

    public void exibirTabuleiro() {
        view.exibirTabuleiro(tabuleiro);
    }

    public boolean realizarJogada(Cor corJogador, int[] posicaoInicial, int[] posicaoFinal) {
        int linhaInicial = posicaoInicial[0];
        int colunaInicial = posicaoInicial[1];
        int linhaFinal = posicaoFinal[0];
        int colunaFinal = posicaoFinal[1];

        Celula celulaInicial = tabuleiro.getCelula(linhaInicial, colunaInicial);
        Celula celulaFinal = tabuleiro.getCelula(linhaFinal, colunaFinal);

        if (celulaFinal.getCor() == Cor.BRANCO) {
            return false;
        }

        if (celulaInicial.getCor() == Cor.BRANCO) {
            return false;
        }

        if (celulaFinal.getPeca() != null) {
            return false;
        }

        if (celulaInicial.getPeca().getCor() != corJogador) {
            return false;
        }

        tabuleiro.setCelula(linhaInicial, colunaInicial, new Celula(Cor.PRETO));
        realizarJogada(linhaFinal, colunaFinal, celulaInicial);

        return true;
    }
}
