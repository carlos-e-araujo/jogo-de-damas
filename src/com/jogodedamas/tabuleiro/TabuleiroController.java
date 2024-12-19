package com.jogodedamas.tabuleiro;

import com.jogodedamas.cor.Cor;
import com.jogodedamas.peca.Peca;

import java.util.Scanner;

public class TabuleiroController extends com.jogodetabuleiro.TabuleiroController<Peca> {

    public TabuleiroController(Tabuleiro tabuleiro, TabuleiroView tabuleiroView) {
        super(tabuleiro, tabuleiroView);
    }

    public void exibirTabuleiro() {
        super.view.exibirTabuleiro(tabuleiro);
    }

    public boolean realizarJogada(Cor corJogador, int[] posicaoInicial, int[] posicaoFinal) {
        Scanner scanner = new Scanner(System.in);

        int linhaInicial = posicaoInicial[0];
        int colunaInicial = posicaoInicial[1];
        int linhaFinal = posicaoFinal[0];
        int colunaFinal = posicaoFinal[1];

        Peca peca = tabuleiro.getCelula(linhaInicial, colunaInicial);

        if (peca == null) {
            view.mostrarMensagem("Jogada invalida.");
            return false;
        }

        if (peca.getCor() != corJogador) {
            view.mostrarMensagem("Jogada invalida.");
            return false;
        }

        if (tabuleiro.getCelula(linhaFinal, colunaFinal) != null) {
            view.mostrarMensagem("Jogada invalida.");
            return false;
        }

        super.realizarJogada(linhaFinal, colunaFinal, tabuleiro.getCelula(linhaInicial, colunaInicial));
        tabuleiro.setCelula(linhaInicial, colunaInicial, null);

        return true;
    }
}
