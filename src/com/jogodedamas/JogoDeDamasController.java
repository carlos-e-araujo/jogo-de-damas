package com.jogodedamas;

import com.jogodedamas.celula.Celula;
import com.jogodedamas.tabuleiro.Tabuleiro;
import com.jogodedamas.tabuleiro.TabuleiroController;
import com.jogodedamas.tabuleiro.TabuleiroView;

public class JogoDeDamasController {
    private final JogoDeDamas jogoDeDamasModel;
    private final JogoDeDamasView jogoDeDamasView;
    private final TabuleiroController tabuleiroController;

    public JogoDeDamasController(JogoDeDamas jogoDeDamasModel) {
        this.jogoDeDamasModel = jogoDeDamasModel;
        this.jogoDeDamasView = new JogoDeDamasView();
        this.tabuleiroController = new TabuleiroController(new Tabuleiro(), new TabuleiroView<Celula>());
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
            }
        }
    }
}
