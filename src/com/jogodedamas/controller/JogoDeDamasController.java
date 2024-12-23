package com.jogodedamas.controller;

import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;
import com.jogodedamas.view.JogoDeDamasView;
import com.jogodedamas.view.TabuleiroView;

public class JogoDeDamasController {
    private final JogoDeDamas jogoDeDamasModel;
    private final JogoDeDamasView jogoDeDamasView;
    private final TabuleiroController tabuleiroController;

    public JogoDeDamasController(JogoDeDamas jogoDeDamasModel, JogoDeDamasView jogoDeDamasView) {
        this.jogoDeDamasModel = jogoDeDamasModel;
        this.jogoDeDamasView = jogoDeDamasView;
        this.tabuleiroController = new TabuleiroController(new Tabuleiro(), new TabuleiroView<>());
    }

    public void iniciarJogo() {
        Posicao origem;
        Posicao destino;

        tabuleiroController.iniciarJogo();

        while (true) {
            final Cor corJogadorAtual = jogoDeDamasModel.getJogadorAtual().getCor();

            this.jogoDeDamasView.exibirJogadorAtual(corJogadorAtual);
            tabuleiroController.exibirTabuleiro();

            origem = jogoDeDamasView.solicitarPeca();
            destino = jogoDeDamasView.solicitarMovimento();

            if (tabuleiroController.realizarJogada(origem, destino, corJogadorAtual)) {
                jogoDeDamasModel.finalizarTurno();
            } else {
                jogoDeDamasView.informarJogadaInvalida();
            }
        }
    }
}
