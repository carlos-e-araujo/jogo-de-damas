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

        if (!(linhaFinal >= 0 && linhaFinal < tabuleiro.getLinhas() && colunaFinal >= 0 && colunaFinal < tabuleiro.getColunas())) {
            return false;
        } else if (!(linhaInicial >= 0 && linhaInicial < tabuleiro.getLinhas() && colunaInicial >= 0 && colunaInicial < tabuleiro.getColunas())) {
            return false;
        } else if (tabuleiro.getCelula(linhaInicial, colunaInicial).getPeca() == null) {
            return false;
        } else if (tabuleiro.getCelula(linhaFinal, colunaFinal).getPeca() != null) {
            return false;
        } else if (tabuleiro.getCelula(linhaFinal, colunaFinal).getCor() == Cor.BRANCO) {
            return false;
        } else if (tabuleiro.getCelula(linhaInicial, colunaInicial).getCor() == Cor.BRANCO) {
            return false;
        } else if (tabuleiro.getCelula(linhaInicial, colunaInicial).getPeca().getCor() != corJogador) {
            return false;
        }

        tabuleiro.setCelula(linhaFinal, colunaFinal, tabuleiro.getCelula(linhaInicial, colunaInicial));
        tabuleiro.setCelula(linhaInicial, colunaInicial, new Celula(Cor.PRETO));

        return true;
    }
}
