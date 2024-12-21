package com.jogodedamas.controller;

import com.jogodedamas.model.Celula;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.model.Tabuleiro;
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

        Celula celula = tabuleiro.getCelula(linhaInicial, colunaInicial);

        if (celula.getPeca().getCor() != corJogador) {
            view.mostrarMensagem("Jogada invalida.");
            return false;
        }

        if (tabuleiro.getCelula(linhaFinal, colunaFinal).getPeca() != null) {
            view.mostrarMensagem("Jogada invalida.");
            return false;
        }

        if (tabuleiro.getCelula(linhaFinal, colunaFinal).getCor() == Cor.BRANCO) {
            view.mostrarMensagem("Jogada invalida.");
            return false;
        }

        tabuleiro.setCelula(linhaInicial, colunaInicial, new Celula(Cor.PRETO));
        realizarJogada(linhaFinal, colunaFinal, celula);

        return true;
    }
}
