package com.jogodedamas.controller;

import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;
import com.jogodedamas.view.TabuleiroSwingView;

public class TabuleiroSwingController {
    private final Tabuleiro modelTabuleiro;
    private final TabuleiroSwingView view;
    Posicao origem = null;
    Posicao destino = null;

    public TabuleiroSwingController(Tabuleiro tabuleiro, TabuleiroSwingView tabuleiroView) {
        this.modelTabuleiro = tabuleiro;
        this.view = tabuleiroView;
    }

    public void atualizarTabuleiroView() {
        view.atualizarPosicoes(modelTabuleiro);
    }

    public boolean realizarJogada(Posicao origem, Posicao destino, Cor corJogador) {
        if (!modelTabuleiro.verificarMovimento(origem, destino, corJogador)) {
            return false;
        }

        if (modelTabuleiro.verificarCaptura(origem, destino)) {
            modelTabuleiro.realizarCaptura(origem, destino);
        } else if (!modelTabuleiro.verificarPasso(origem, destino)) {
            return false;
        }

        modelTabuleiro.realizarMovimento(origem, destino);

        if (modelTabuleiro.verificarPromocao(destino)) {
            modelTabuleiro.realizarPromocao(destino);
        }

        return true;
    }

    private void registrarEventoJButtonClick() {
        for (int i = 0; i < modelTabuleiro.getColunas(); i++) {
            for (int j = 0; j < modelTabuleiro.getLinhas(); j++) {
                final int col = i;
                final int row = j;

                view.getCasaJButton()[i][j].addActionListener(e -> {
                    if (modelTabuleiro.getCelula(col, row).getPeca() != null) {
                        if (modelTabuleiro.getCelula(col, row).getPeca().getCor() == Cor.BRANCO) {
                            if (modelTabuleiro.getCelula(col, row).getPeca().getCor() == Cor.PRETO) {
                                return;
                            }
                        }

                        if (modelTabuleiro.getCelula(col, row).getPeca().getCor() == Cor.PRETO) {
                            if (modelTabuleiro.getCelula(col, row).getPeca().getCor() == Cor.BRANCO) {
                                return;
                            }
                        }

                        this.origem = Posicao.toPosicao(col, row);
                    } else {
                        this.destino = Posicao.toPosicao(col, row);
                    }

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

    public void finalizarJogo() {
    }
}
