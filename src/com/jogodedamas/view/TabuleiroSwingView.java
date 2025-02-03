package com.jogodedamas.view;

import com.jogodedamas.model.Comum;
import com.jogodedamas.model.Dama;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;

import javax.swing.*;
import java.awt.*;

public class TabuleiroSwingView extends JFrame {
    private final JButton[][] casas;

    public TabuleiroSwingView() {
        setTitle("Jogo de Damas");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel tabuleiroPanel = new JPanel(new GridLayout(8, 8));
        this.casas = new JButton[8][8];

        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                JButton casa = new JButton();

                this.casas[linha][coluna] = casa;
                this.casas[linha][coluna].setFont(new Font("Arial", Font.PLAIN, 50));

                tabuleiroPanel.add(casa);
            }
        }

        this.add(tabuleiroPanel);
    }

    public void atualizarPosicoes(final Tabuleiro tabuleiro) {
        int linhas = tabuleiro.getLinhas();
        int colunas = tabuleiro.getColunas();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (tabuleiro.getCelula(i, j).getPeca() == null) {
                    this.casas[i][j].setText(" ");
                } else {
                    if (tabuleiro.getCelula(i, j).getPeca() instanceof Dama) {
                        this.casas[i][j].setText("◼");
                    } else if ((tabuleiro.getCelula(i, j).getPeca() instanceof Comum)) {
                        this.casas[i][j].setText("●");
                    }

                    if (tabuleiro.getCelula(i, j).getPeca().getCor() == Cor.BRANCO) {
                        this.casas[i][j].setForeground(Color.WHITE);
                    } else {
                        this.casas[i][j].setForeground(Color.BLACK);
                    }
                }
            }
        }
    }

    public void iniciarTabuleiro(final Tabuleiro tabuleiro) {
        this.setVisible(true);

        int linhas = tabuleiro.getLinhas();
        int colunas = tabuleiro.getColunas();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (tabuleiro.getCelula(i, j).getCor() == Cor.BRANCO) {
                    this.casas[i][j].setBackground(Color.WHITE);
                } else {
                    this.casas[i][j].setBackground(Color.GREEN);
                }
            }
        }

        this.atualizarPosicoes(tabuleiro);
    }
}

