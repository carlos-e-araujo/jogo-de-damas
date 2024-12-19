package com.jogodedamas;

import com.jogodedamas.cor.Cor;

public class JogoDeDamasView {
    public void exibirJogadorAtual(Cor corJogador) {
        System.out.println("Vez do jogador " + ((corJogador == Cor.BRANCO) ? "Branco" : "Preto"));
    }
}
