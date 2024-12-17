package com.jogodedamas;

import com.jogodedamas.cor.Cor;
import com.jogodedamas.jogador.Jogador;

public class JogoDeDamas {

    private final Jogador jogadorB;
    private final Jogador jogadorP;
    private Jogador jogadorAtual;

    public JogoDeDamas() {
        this.jogadorP = new Jogador(Cor.PRETO);
        this.jogadorB = new Jogador(Cor.BRANCO);
        this.jogadorAtual = this.jogadorB;
    }

    public void finalizarTurno() {
        this.jogadorAtual = (this.jogadorAtual == this.jogadorB) ? this.jogadorP : this.jogadorB;
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }
}