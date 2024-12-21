package com.jogodedamas.view;

import com.jogodedamas.model.Celula;
import com.jogodedamas.model.Dama;
import com.jogodedamas.utils.Cor;
import com.jogodetabuleiro.Tabuleiro;

public class TabuleiroView<T extends Celula> extends com.jogodetabuleiro.TabuleiroView<T> {
    final String ANSI_BG_BLACK = "\033[48;2;1;100;1m";
    final String ANSI_BG_WHITE = "\033[48;2;255;255;255m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_WHITE = "\033[38;2;255;255;255m";
    final String ANSI_RESET = "\u001B[0m";

    @Override
    public void exibirTabuleiro(final Tabuleiro<T> tabuleiro) {
        int linhas = tabuleiro.getLinhas();
        int colunas = tabuleiro.getColunas();

        System.out.println();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                String saida;

                saida = ((tabuleiro.getCelula(i, j).getCor() == Cor.PRETO) ? (ANSI_BG_BLACK) : (ANSI_BG_WHITE)) + " ";

                if (tabuleiro.getCelula(i, j).getPeca() == null) {
                    saida += " ";
                } else {
                    saida += (tabuleiro.getCelula(i, j).getPeca().getCor() == Cor.PRETO) ? (ANSI_BLACK) : (ANSI_WHITE);

                    if (tabuleiro.getCelula(i, j).getPeca() instanceof Dama) {
                        saida += "◼";
                    } else {
                        saida += "●";
                    }
                }

                saida += " " + ANSI_RESET;

                System.out.print(saida);
            }
            System.out.println();
        }
        System.out.println();
    }
}
