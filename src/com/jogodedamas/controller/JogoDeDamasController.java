package com.jogodedamas.controller;

import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.view.TabuleiroView;
import com.jogodedamas.view.JogoDeDamasView;

public class JogoDeDamasController {
    private final JogoDeDamas jogoDeDamasModel;
    private final JogoDeDamasView jogoDeDamasView;
    private final TabuleiroController tabuleiroController;

    public JogoDeDamasController(JogoDeDamas jogoDeDamasModel) {
        this.jogoDeDamasModel = jogoDeDamasModel;
        this.jogoDeDamasView = new JogoDeDamasView();
        this.tabuleiroController = new TabuleiroController(new Tabuleiro(), new TabuleiroView<>());
    }

    public void iniciarJogo() {
        int[] posicaoIncial;
        int[] posicaoFinal;

        while (true) {
            this.jogoDeDamasView.exibirJogadorAtual(jogoDeDamasModel.getJogadorAtual().getCor());
            tabuleiroController.exibirTabuleiro();

            posicaoIncial = jogoDeDamasView.solicitarPeca();
            posicaoFinal = jogoDeDamasView.solicitarMovimento();

            if (tabuleiroController.realizarJogada(jogoDeDamasModel.getJogadorAtual().getCor(), posicaoIncial, posicaoFinal)) {
                jogoDeDamasModel.finalizarTurno();
            } else {
                jogoDeDamasView.informarJogadaInvalida();
            }
        }
    }
}
