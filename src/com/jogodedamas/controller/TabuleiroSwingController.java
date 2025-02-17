package com.jogodedamas.controller;

import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;
import com.jogodedamas.utils.PosicaoListener;
import com.jogodedamas.view.TabuleiroSwingView;

public class TabuleiroSwingController implements PosicaoListener {
    private Tabuleiro modelTabuleiro;
    private TabuleiroSwingView view;
    private Posicao posicaoSelecionada;

    public TabuleiroSwingController(Tabuleiro tabuleiro, TabuleiroSwingView tabuleiroView) {
        this.modelTabuleiro = tabuleiro;
        this.view = tabuleiroView;
        this.posicaoSelecionada = Posicao.INVALIDA;
        tabuleiroView.setPosicaoListener(this);
    }

    @Override
    public void posicaoSelecionada(Posicao posicao) {
        this.posicaoSelecionada = posicao;
    }

    public Posicao getPosicaoSelecionada() {
        System.out.println("getPosicaoSelecionada: " + posicaoSelecionada.toString());
        return posicaoSelecionada;
    }

    public void resetPosicaoSelecionada() {
        posicaoSelecionada = Posicao.INVALIDA;
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

    public boolean verificarFimDeJogo() {
        return modelTabuleiro.verificarFimDeJogo();
    }

    public Cor getCorComMaisPecas() {
        return (modelTabuleiro.getQtdPecasBrancas() > modelTabuleiro.getQtdPecasPretas()) ? Cor.BRANCO : Cor.PRETO;
    }

    public void iniciarJogo() {
        view.iniciarTabuleiro(modelTabuleiro);
    }

    public void finalizarJogo() {
    }
}
