package com.jogodedamas.controller;

import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.view.TabuleiroSwingView;

public class JogoDeDamasSwingController {
    private final JogoDeDamas jogoDeDamasModel;
    private final TabuleiroSwingController tabuleiroController;

    public JogoDeDamasSwingController(JogoDeDamas jogoDeDamasModel) {
        this.jogoDeDamasModel = jogoDeDamasModel;
        this.tabuleiroController = new TabuleiroSwingController(new Tabuleiro(), new TabuleiroSwingView());
    }

    public void iniciarJogo() {
        tabuleiroController.iniciarJogo();

        while (!tabuleiroController.verificarFimDeJogo()) {
            if (tabuleiroController.getOrigem() != null && tabuleiroController.getDestino() != null) {
                if (tabuleiroController.realizarJogada(tabuleiroController.getOrigem(), tabuleiroController.getDestino(), jogoDeDamasModel.getJogadorAtual().getCor())) {
                    jogoDeDamasModel.finalizarTurno();
                }

                tabuleiroController.resetarOrigemDestino();
            }

            tabuleiroController.atualizarTabuleiroView();
        }
    }
}
