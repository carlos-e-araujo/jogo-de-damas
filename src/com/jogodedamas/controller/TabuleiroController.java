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

    public boolean realizarJogada(Posicao origem, Posicao destino, Cor corJogador) {
        if (!modelTabuleiro.verificarJogada(origem, destino, corJogador)) {
            return false;
        }

        modelTabuleiro.moverPeca(origem, destino);

        if (modelTabuleiro.verificarCaptura(origem, destino)) {
            modelTabuleiro.realizarCaptura(origem, destino);
        }

        if (modelTabuleiro.verificarPromocao(destino)) {
            modelTabuleiro.realizarPromocao(destino);
        }

        return true;
    }
}
