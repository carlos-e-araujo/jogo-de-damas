package com.jogodetabuleiro;

public class Tabuleiro<T> {
    private T[][] celulas;

    public Tabuleiro(int linhas, int colunas) {
        celulas = (T[][]) new Object[linhas][colunas];
    }

    public T getCelula(int linha, int coluna) {
        return celulas[linha][coluna];
    }

    public void setCelula(int linha, int coluna, T valor) {
        celulas[linha][coluna] = valor;
    }

    public int getLinhas() {
        return celulas.length;
    }

    public int getColunas() {
        return celulas[0].length;
    }
}
