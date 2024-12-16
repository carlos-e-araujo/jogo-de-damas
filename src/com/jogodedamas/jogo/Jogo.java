package com.jogodedamas.jogo;

public class Jogo {
    private char jogadorAtual;
    private int contadorMovimentos;

    public Jogo() {
        this.jogadorAtual = 'b';
    }

    public void finalizarTurno() {
        this.jogadorAtual = (jogadorAtual == 'b') ? 'p' : 'b';
    }

    public char getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(char jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public int getContadorMovimentos() {
        return contadorMovimentos;
    }

    public void setContadorMovimentos(int contadorMovimentos) {
        this.contadorMovimentos = contadorMovimentos;
    }
}
