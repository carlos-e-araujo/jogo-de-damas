package com.jogodedamas.controller;

import com.jogodedamas.model.Posicao;
import com.jogodedamas.model.TabuleiroDamas;
import com.jogodedamas.view.TabuleiroDamasView;
import com.jogodedamas.jogodetabuleiro.TabuleiroController;
import com.jogodedamas.model.Peca;

public class TabuleiroDamasController extends TabuleiroController<Peca> {
    public TabuleiroDamasController(TabuleiroDamas tabuleiro, TabuleiroDamasView tView) {
        super(tabuleiro, tView);
    }

    public void moverPeca(Peca peca, Posicao destino) {
    }

    public void exibirTabuleiro() {
        super.view.exibirTabuleiro(tabuleiro);
    }
}
