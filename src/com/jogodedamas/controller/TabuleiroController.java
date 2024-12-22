package com.jogodedamas.controller;

import com.jogodedamas.model.Celula;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.view.TabuleiroView;

public class TabuleiroController extends com.jogodetabuleiro.TabuleiroController<Celula> {
    Tabuleiro modelTabuleiro;

    public TabuleiroController(Tabuleiro tabuleiro, TabuleiroView<Celula> tabuleiroView) {
        super(tabuleiro, tabuleiroView);
        this.modelTabuleiro = (Tabuleiro) this.tabuleiro;
    }

    public void exibirTabuleiro() {
        view.exibirTabuleiro(tabuleiro);
    }

    public boolean realizarJogada(Cor corJogador, int[] posicaoInicial, int[] posicaoFinal) {
        int linhaInicial = posicaoInicial[0];
        int colunaInicial = posicaoInicial[1];
        int linhaFinal = posicaoFinal[0];
        int colunaFinal = posicaoFinal[1];

        if (!modelTabuleiro.verificarJogada(linhaInicial, colunaInicial, linhaFinal, colunaFinal, corJogador)) {
            return false;
        }

        modelTabuleiro.moverPeca(linhaInicial, colunaInicial, linhaFinal, colunaFinal);
        return true;
    }
}
