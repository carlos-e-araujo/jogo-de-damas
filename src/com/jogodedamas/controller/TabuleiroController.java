package com.jogodedamas.controller;

import com.jogodedamas.model.Posicao;
import com.jogodedamas.model.TabuleiroDamas;
import com.jogodedamas.view.TabuleiroDamasView;
import com.jogodedamas.model.Peca;

public class TabuleiroController {
    private TabuleiroDamas tabuleiro;
    private TabuleiroDamasView tView;

    public TabuleiroController(TabuleiroDamas tabuleiro, TabuleiroDamasView tView) {
        this.tabuleiro = tabuleiro;
        this.tView = tView;
    }

    public void moverPeca(Peca peca, Posicao destino) {

    }

    public void exibirTabuleiro() {
        tView.exibirTabuleiro(tabuleiro);
    }
}
