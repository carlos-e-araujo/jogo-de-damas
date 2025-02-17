package com.jogodedamas.controller;

import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;
import com.jogodedamas.view.TabuleiroSwingView;

public class TabuleiroSwingController {
    private final Tabuleiro modelTabuleiro;
    private final TabuleiroSwingView view;
    private final JogoDeDamasSwingController jogoDeDamasController;
    Posicao origem = null;
    Posicao destino = null;

    public TabuleiroSwingController(Tabuleiro tabuleiro, TabuleiroSwingView tabuleiroView) {
        this.modelTabuleiro = tabuleiro;
        this.view = tabuleiroView;
        this.jogoDeDamasController = new JogoDeDamasSwingController(new JogoDeDamas());
    }

    public void atualizarTabuleiroView() {
        view.atualizarPosicoes(modelTabuleiro);
        view.atualizarJogadorAtual(jogoDeDamasController.getCorJogadorAtual());
    }

    public boolean realizarJogada(Posicao origem, Posicao destino, Cor corJogador) {
        if (!modelTabuleiro.verificarMovimento(origem, destino, corJogador)) {
            view.atualizarStatus("Jogada inválida. Tente novamente.");
            return false;
        }

        if (modelTabuleiro.verificarCaptura(origem, destino)) {
            modelTabuleiro.realizarCaptura(origem, destino);
        } else if (!modelTabuleiro.verificarPasso(origem, destino)) {
            view.atualizarStatus("Jogada inválida. Tente novamente.");
            return false;
        }

        modelTabuleiro.realizarMovimento(origem, destino);

        if (modelTabuleiro.verificarPromocao(destino)) {
            modelTabuleiro.realizarPromocao(destino);
        }

        view.atualizarStatus("Troca de turno.");
        return true;
    }

    private void registrarEventoJButtonClick() {
        for (int i = 0; i < modelTabuleiro.getColunas(); i++) {
            for (int j = 0; j < modelTabuleiro.getLinhas(); j++) {
                final int col = i;
                final int row = j;

                view.getCasaJButton()[i][j].addActionListener(e -> {
                    if (modelTabuleiro.getCelula(col, row).getPeca() != null) {
                        this.origem = Posicao.toPosicao(col, row);
                    } else {
                        this.destino = Posicao.toPosicao(col, row);
                    }

                    if (this.getOrigem() != null && this.getDestino() != null) {
                        if (this.realizarJogada(this.getOrigem(), this.getDestino(), jogoDeDamasController.getCorJogadorAtual())) {
                            jogoDeDamasController.finalizarTurno();
                        }

                        this.resetarOrigemDestino();
                    }

                    if (this.verificarFimDeJogo()) {
                        view.mostrarFimDeJogo("Fim de Jogo! O jogador " + (jogoDeDamasController.getCorJogadorAtual() == Cor.BRANCO ? "Preto" : "Branco") + " venceu.");
                        System.exit(0);
                    }

                    this.atualizarTabuleiroView();

                    atualizarTabuleiroView();
                });
            }
        }
    }

    public boolean verificarFimDeJogo() {
        return modelTabuleiro.verificarFimDeJogo();
    }

    public Cor getCorComMaisPecas() {
        return (modelTabuleiro.getQtdPecasBrancas() > modelTabuleiro.getQtdPecasPretas()) ? Cor.BRANCO : Cor.PRETO;
    }

    public void iniciarJogo() {
        view.iniciarTabuleiro(modelTabuleiro);
        view.atualizarJogadorAtual(jogoDeDamasController.getCorJogadorAtual());
        view.atualizarStatus("Jogo iniciado. Vez do jogador: " + (jogoDeDamasController.getCorJogadorAtual() == Cor.BRANCO ? "Branco" : "Preto"));
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
