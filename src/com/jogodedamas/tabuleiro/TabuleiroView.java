package com.jogodedamas.tabuleiro;

import com.jogodedamas.celula.Celula;
import com.jogodedamas.cor.Cor;
import com.jogodedamas.peca.Peca;
import com.jogodetabuleiro.Tabuleiro;

public class TabuleiroView<T extends Celula> extends com.jogodetabuleiro.TabuleiroView<T> {
    @Override
    public void exibirTabuleiro(final Tabuleiro<T> tabuleiro) {
        final String ANSI_BG_BLACK = "\033[48;5;0m";
        final String ANSI_BG_WHITE = "\033[48;5;15m";
        final String ANSI_BLACK = "\033[34;5;0m";
        final String ANSI_WHITE = "\033[37;5;2m";
        final String ANSI_RESET = "\033[0m";

        int linhas = tabuleiro.getLinhas();
        int colunas = tabuleiro.getColunas();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Celula celula = tabuleiro.getCelula(i, j);
                Peca conteudo = celula.getPeca();
                String saida = (conteudo == null) ? " " : conteudo.toString();
                System.out.print(((celula.getCor() == Cor.PRETO) ? (ANSI_BG_BLACK) : (ANSI_BG_WHITE)) + " " + saida + " " + ANSI_RESET);
            }
            System.out.println();
        }
        System.out.println();
    }
}
