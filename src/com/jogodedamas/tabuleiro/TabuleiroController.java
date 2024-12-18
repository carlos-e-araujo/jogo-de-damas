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

    public boolean realizarJogada(Cor corJogador) {
        Scanner scanner = new Scanner(System.in);

        int linhaInicial;
        int colunaInicial;
        int linhaFinal;
        int colunaFinal;

        System.out.println("Escolha uma peça no tabuleiro");
        System.out.print("Linha: ");
        linhaInicial = scanner.nextInt();

        System.out.print("Coluna: ");
        colunaInicial = scanner.nextInt();

        Peca peca = tabuleiro.getCelula(linhaInicial, colunaInicial);

        if (peca == null) {
            System.out.println("Jogada invalida.");
            return false;
        }

        if (peca.getCor() != corJogador) {
            System.out.println("Jogada invalida.");
            return false;
        }

        System.out.println("Informe a posição que deseja mover a peça");
        System.out.print("Linha: ");
        linhaFinal = scanner.nextInt();

        System.out.print("Coluna: ");
        colunaFinal = scanner.nextInt();

        if (tabuleiro.getCelula(linhaFinal, colunaFinal) != null) {
            System.out.println("Jogada invalida.");
            return false;
        }

        super.realizarJogada(linhaFinal, colunaFinal, tabuleiro.getCelula(linhaInicial, colunaInicial));
        tabuleiro.setCelula(linhaInicial, colunaInicial, null);

        return true;
    }
}
