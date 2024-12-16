package com.jogodedamas.jogo;

import com.jogodedamas.tabuleiro.TabuleiroDamas;
import com.jogodedamas.tabuleiro.TabuleiroDamasController;
import com.jogodedamas.tabuleiro.TabuleiroDamasView;

public class JogoController {
    private final Jogo jogoModel;
    private final JogoView jogoView;
    private final TabuleiroDamasController tabuleiroDamasController;

    public JogoController(Jogo jogoModel, JogoView jogoView) {
        this.jogoModel = jogoModel;
        this.jogoView = jogoView;
        this.tabuleiroDamasController = new TabuleiroDamasController(new TabuleiroDamas(), new TabuleiroDamasView());
    }

    public void iniciarJogo() {
        do {
            System.out.println("Vez do jogador " + ((jogoModel.getJogadorAtual() == 'b') ? "Branco" : "Preto"));

            tabuleiroDamasController.exibirTabuleiro();

            if (tabuleiroDamasController.realizarJogada(jogoModel.getJogadorAtual())) {
                jogoModel.finalizarTurno();
            }
        } while (true);
    }
}
