package com.jogodedamas;

import com.jogodedamas.cor.Cor;
import com.jogodedamas.tabuleiro.Tabuleiro;
import com.jogodedamas.tabuleiro.TabuleiroController;
import com.jogodedamas.tabuleiro.TabuleiroView;

public class JogoDeDamasController {

    private final JogoDeDamas jogoDeDamasModel;
    private final TabuleiroController tabuleiroController;

    public JogoDeDamasController(JogoDeDamas jogoDeDamasModel) {
        this.jogoDeDamasModel = jogoDeDamasModel;
        this.tabuleiroController = new TabuleiroController(new Tabuleiro(), new TabuleiroView());
    }

    public void iniciarJogo() {
        while (true) {
            System.out.println("Vez do jogador " + ((jogoDeDamasModel.getJogadorAtual().getCor() == Cor.BRANCO) ? "Branco" : "Preto"));

            tabuleiroController.exibirTabuleiro();

            if (tabuleiroController.realizarJogada(jogoDeDamasModel.getJogadorAtual().getCor())) {
                jogoDeDamasModel.finalizarTurno();
            }
        }
    }
}
