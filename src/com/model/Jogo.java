package model;

public class Jogo {
    private char jogadorAtual;
    private int contadorMovimentos;

    public Jogo() {
        // TODO: constructor
    }

    public void iniciarTurno() {
        // TODO: iniciarTurno
    }

    public void finalizarTurno() {
        // TODO: finalizarTurno
    }

    public boolean verificarFimDeTurno() {
        // TODO: verificarFimDeTurno
        return false;
    }

    public boolean verificarEmpate() {
        // TODO: verificarEmpate
        return false;
    }

    // Getters and Setters
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
