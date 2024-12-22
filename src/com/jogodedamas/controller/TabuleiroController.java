package com.jogodedamas.controller;

import com.jogodedamas.model.Celula;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;
import com.jogodedamas.view.TabuleiroView;

public class TabuleiroController extends com.jogodetabuleiro.TabuleiroController<Celula> {
    private final Tabuleiro modelTabuleiro;

    public TabuleiroController(Tabuleiro tabuleiro, TabuleiroView<Celula> tabuleiroView) {
        super(tabuleiro, tabuleiroView);
        this.modelTabuleiro = (Tabuleiro) this.tabuleiro;
    }

    public void exibirTabuleiro() {
        view.exibirTabuleiro(tabuleiro);
    }

    public boolean realizarJogada(Cor corJogador, Posicao posicaoInicial, Posicao posicaoFinal) {
        if (!modelTabuleiro.verificarJogada(posicaoInicial, posicaoFinal, corJogador)) {
            return false;
        }

        modelTabuleiro.moverPeca(posicaoInicial, posicaoFinal);
        return true;
    }
}
