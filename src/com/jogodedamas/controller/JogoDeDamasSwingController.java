package com.jogodedamas.controller;

import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;
import com.jogodedamas.view.JogoDeDamasView;
import com.jogodedamas.view.TabuleiroSwingView;

public class JogoDeDamasSwingController {
    private final JogoDeDamas jogoDeDamasModel;
    private final JogoDeDamasView jogoDeDamasView;
    private final TabuleiroSwingController tabuleiroController;

    public JogoDeDamasSwingController(JogoDeDamas jogoDeDamasModel, JogoDeDamasView jogoDeDamasView) {
        this.jogoDeDamasModel = jogoDeDamasModel;
        this.jogoDeDamasView = jogoDeDamasView;
        this.tabuleiroController = new TabuleiroSwingController(new Tabuleiro(), new TabuleiroSwingView());
    }

    public void iniciarJogo() {
        tabuleiroController.iniciarJogo();

        while (!tabuleiroController.verificarFimDeJogo()) {
            Posicao origem = null;
            Posicao destino = null;

            final Cor corJogadorAtual = jogoDeDamasModel.getJogadorAtual().getCor();

            this.jogoDeDamasView.exibirJogadorAtual(corJogadorAtual);
            tabuleiroController.exibirTabuleiro();

            while (origem == null || origem == Posicao.INVALIDA) {
            }

            while (destino == null || destino == Posicao.INVALIDA) {
            }

            if (tabuleiroController.realizarJogada(origem, destino, corJogadorAtual)) {
                jogoDeDamasModel.finalizarTurno();
            } else {
                jogoDeDamasView.informarJogadaInvalida();
            }
        }

        jogoDeDamasView.informarVencedor(tabuleiroController.getCorComMaisPecas());
        tabuleiroController.exibirTabuleiro();
        tabuleiroController.finalizarJogo();
    }
}
