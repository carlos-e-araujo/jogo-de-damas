package com.jogodedamas.view;

import com.jogodedamas.model.Celula;
import com.jogodedamas.model.Dama;
import com.jogodedamas.utils.Cor;
import com.jogodetabuleiro.Tabuleiro;

/**
 * Classe TabuleiroView
 * Representa a visualização do tabuleiro no jogo de damas.
 *
 * <p>Esta classe é responsável por exibir o tabuleiro e suas peças no console.</p>
 *
 * @author Carlos
 * @author Isaias
 * @version 1.0
 * @since 2024
 */
public class TabuleiroView<T extends Celula> extends com.jogodetabuleiro.TabuleiroView<T> {
    final String ANSI_BG_BLACK = "\033[48;2;1;100;1m";
    final String ANSI_BG_WHITE = "\033[48;2;255;255;255m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_WHITE = "\033[38;2;255;255;255m";
    final String ANSI_RESET = "\u001B[0m";

    /**
     * Exibe o tabuleiro no terminal.
     *
     * @param tabuleiro O tabuleiro a ser exibido.
     */
    @Override
    public void exibirTabuleiro(final Tabuleiro<T> tabuleiro) {
        int linhas = tabuleiro.getLinhas();
        int colunas = tabuleiro.getColunas();

        System.out.println();
        System.out.print("   ");
        for (int j = 0; j < linhas; j++) {
            System.out.printf(" " + (j + 1) + " ");
        }
        System.out.println();

        char identificadorLinha = 'A';

        for (int i = 0; i < linhas; i++) {
            System.out.print(" " + identificadorLinha + " ");
            identificadorLinha++;

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
