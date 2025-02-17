package com.jogodedamas.view;

import com.jogodedamas.model.Comum;
import com.jogodedamas.model.Dama;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;

import javax.swing.*;
import java.awt.*;

public class TabuleiroView extends JFrame {
    private final JButton[][] casaJButtons;
    private final JLabel jogadorAtualLabel;
    private final JLabel statusLabel;

    public TabuleiroView() {
        setTitle("Jogo de Damas");
        setSize(800, 900);
        setMinimumSize(new Dimension(800, 800));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        jogadorAtualLabel = new JLabel("Vez do jogador: ");
        jogadorAtualLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jogadorAtualLabel.setFont(new Font("Arial", Font.BOLD, 20));
        jogadorAtualLabel.setOpaque(true);
        jogadorAtualLabel.setBackground(Color.BLACK);
        jogadorAtualLabel.setForeground(Color.WHITE);
        jogadorAtualLabel.setBorder(null);
        this.add(jogadorAtualLabel, BorderLayout.NORTH);

        statusLabel = new JLabel(" ");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        statusLabel.setOpaque(true);
        statusLabel.setBackground(Color.BLACK);
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setBorder(null);
        this.add(statusLabel, BorderLayout.SOUTH);

        JPanel tabuleiroPanel = new JPanel(new GridLayout(8, 8));
        this.casaJButtons = new JButton[8][8];

        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                JButton casaJButton = new JButton();

                this.casaJButtons[linha][coluna] = casaJButton;
                this.casaJButtons[linha][coluna].setFont(new Font("Arial", Font.PLAIN, 50));
                this.casaJButtons[linha][coluna].setFocusPainted(false);
                this.casaJButtons[linha][coluna].setBorderPainted(false);

                this.casaJButtons[linha][coluna].addActionListener(e -> {
                });

                tabuleiroPanel.add(casaJButton);
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
                    this.casaJButtons[i][j].setText(" ");
                } else {
                    if (tabuleiro.getCelula(i, j).getPeca() instanceof Dama) {
                        this.casaJButtons[i][j].setText("◼");
                    } else if ((tabuleiro.getCelula(i, j).getPeca() instanceof Comum)) {
                        this.casaJButtons[i][j].setText("●");
                    }

                    if (tabuleiro.getCelula(i, j).getPeca().getCor() == Cor.BRANCO) {
                        this.casaJButtons[i][j].setForeground(Color.WHITE);
                    } else {
                        this.casaJButtons[i][j].setForeground(Color.BLACK);
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
                    this.casaJButtons[i][j].setBackground(Color.WHITE);
                } else {
                    this.casaJButtons[i][j].setBackground(Color.GREEN);
                }
            }
        }

        this.atualizarPosicoes(tabuleiro);
    }

    public void atualizarJogadorAtual(Cor corJogador) {
        jogadorAtualLabel.setText("Vez do jogador: " + (corJogador == Cor.BRANCO ? "Branco" : "Preto"));
    }

    public void statusInicioDeJogo() {
        statusLabel.setText("Jogo Iniciado.");
    }

    public void statusTrocaDeTurno() {
        statusLabel.setText("Troca de turno.");
    }

    public void statusJogadaInvalida() {
        statusLabel.setText("Jogada inválida. Tente Novamente.");
    }

    public void statusPecaSelecionada() {
        statusLabel.setText("Peça Selecionada.");
    }

    public void mostrarFimDeJogo(Cor corVencedor) {
        String mensagem = "Fim de Jogo! O jogador " + (corVencedor == Cor.BRANCO ? "Preto" : "Branco") + " venceu.";
        JOptionPane.showMessageDialog(this, mensagem, "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
    }

    public JButton[][] getCasaJButton() {
        return this.casaJButtons;
    }
}
