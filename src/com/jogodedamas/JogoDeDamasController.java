package com.jogodedamas;

import com.jogodedamas.tabuleiro.TabuleiroDamas;
import com.jogodedamas.tabuleiro.TabuleiroDamasController;
import com.jogodedamas.tabuleiro.TabuleiroDamasView;

public class JogoDeDamasController {
    private final JogoDeDamas jogoDeDamasModel;
    private final JogoDeDamasView jogoDeDamasView;
    private final TabuleiroDamasController tabuleiroDamasController;

    public JogoDeDamasController(JogoDeDamas jogoDeDamasModel, JogoDeDamasView jogoDeDamasView) {
        this.jogoDeDamasModel = jogoDeDamasModel;
        this.jogoDeDamasView = jogoDeDamasView;
        this.tabuleiroDamasController = new TabuleiroDamasController(new TabuleiroDamas(), new TabuleiroDamasView());
    }

    public void iniciarJogo() {
        do {
            System.out.println("Vez do jogador " + ((jogoDeDamasModel.getJogadorAtual() == 'b') ? "Branco" : "Preto"));

            tabuleiroDamasController.exibirTabuleiro();

            if (tabuleiroDamasController.realizarJogada(jogoDeDamasModel.getJogadorAtual())) {
                jogoDeDamasModel.finalizarTurno();
            }
        } while (true);
    }
}
