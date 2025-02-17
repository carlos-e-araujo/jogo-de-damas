package com.jogodedamas.controller;

import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;
import com.jogodedamas.view.TabuleiroView;

public class TabuleiroController {
    private final Tabuleiro model;
    private final TabuleiroView view;

    private final JogoDeDamasController jogoDeDamasController;

    private Posicao origem = null;
    private Posicao destino = null;

    public TabuleiroController(Tabuleiro tabuleiro, TabuleiroView tabuleiroView) {
        this.model = tabuleiro;
        this.view = tabuleiroView;
        this.jogoDeDamasController = new JogoDeDamasController(new JogoDeDamas());
    }

    public void atualizarTabuleiroView() {
        view.atualizarPosicoes(model);
        view.atualizarJogadorAtual(jogoDeDamasController.getCorJogadorAtual());
    }

    public boolean realizarJogada(Posicao origem, Posicao destino, Cor corJogador) {
        if (!model.verificarMovimento(origem, destino, corJogador)) {
            view.statusJogadaInvalida();
            return false;
        }

        if (model.verificarCaptura(origem, destino)) {
            model.realizarCaptura(origem, destino);
        } else if (!model.verificarPasso(origem, destino)) {
            view.statusJogadaInvalida();
            return false;
        }

        model.realizarMovimento(origem, destino);

        if (model.verificarPromocao(destino)) {
            model.realizarPromocao(destino);
        }

        view.statusTrocaDeTurno();
        return true;
    }

    private void registrarEventoJButtonClick() {
        for (int i = 0; i < model.getColunas(); i++) {
            for (int j = 0; j < model.getLinhas(); j++) {
                final int col = i;
                final int row = j;

                view.getCasaJButton()[i][j].addActionListener(e -> {
                    if (this.origem != null && this.destino == null) {
                        this.destino = Posicao.toPosicao(col, row);
                    }

                    if (this.origem == null) {
                        this.origem = Posicao.toPosicao(col, row);
                        this.view.statusPecaSelecionada();
                    }

                    if (this.getOrigem() != null && this.getDestino() != null) {
                        if (this.realizarJogada(this.getOrigem(), this.getDestino(), jogoDeDamasController.getCorJogadorAtual())) {
                            jogoDeDamasController.finalizarTurno();
                        } else {
                            view.statusJogadaInvalida();
                        }

                        this.resetarOrigemDestino();
                    }

                    if (this.verificarFimDeJogo()) {
                        view.mostrarFimDeJogo(jogoDeDamasController.getCorJogadorAtual());
                        System.exit(0);
                    }

                    this.atualizarTabuleiroView();

                    atualizarTabuleiroView();
                });
            }
        }
    }

    public boolean verificarFimDeJogo() {
        return model.verificarFimDeJogo();
    }

    public void iniciarJogo() {
        view.iniciarTabuleiro(model);
        view.atualizarJogadorAtual(jogoDeDamasController.getCorJogadorAtual());
        view.statusInicioDeJogo();
        this.registrarEventoJButtonClick();
    }

    public void resetarOrigemDestino() {
        this.origem = null;
        this.destino = null;
    }

    public Posicao getOrigem() {
        return this.origem;
    }

    public Posicao getDestino() {
        return this.destino;
    }
}
