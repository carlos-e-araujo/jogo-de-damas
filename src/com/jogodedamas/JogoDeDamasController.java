package com.jogodedamas;

import com.jogodedamas.cor.COR;
import com.jogodedamas.tabuleiro.TabuleiroDamas;
import com.jogodedamas.tabuleiro.TabuleiroDamasController;
import com.jogodedamas.tabuleiro.TabuleiroDamasView;

public class JogoDeDamasController {
    private final JogoDeDamas jogoDeDamasModel;
    private final TabuleiroDamasController tabuleiroDamasController;

    public JogoDeDamasController(JogoDeDamas jogoDeDamasModel) {
        this.jogoDeDamasModel = jogoDeDamasModel;
        this.tabuleiroDamasController = new TabuleiroDamasController(new TabuleiroDamas(), new TabuleiroDamasView());
    }

    public void iniciarJogo() {
        while (true) {
            System.out.println("Vez do jogador " + ((jogoDeDamasModel.getJogadorAtual().getCor() == COR.BRANCO) ? "Branco" : "Preto"));

            tabuleiroDamasController.exibirTabuleiro();

            if (tabuleiroDamasController.realizarJogada(jogoDeDamasModel.getJogadorAtual().getCor())) {
                jogoDeDamasModel.finalizarTurno();
            }
        }
    }
}
