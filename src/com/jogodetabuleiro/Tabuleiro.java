package com.jogodetabuleiro;

public class Tabuleiro<T> {
    private final T[][] celulas;

    @SuppressWarnings("unchecked")
    public Tabuleiro(int linhas, int colunas) {
        if (linhas <= 0 || colunas <= 0) {
            throw new IllegalArgumentException("Linhas e colunas devem ser maiores que zero.");
        }
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
