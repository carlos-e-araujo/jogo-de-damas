package com.jogodedamas.utils;

/**
 * Enumeração Posicao
 * Representa as posições no tabuleiro de um jogo de damas.
 *
 * <p>Cada posição é representada por uma linha e uma coluna.</p>
 *
 * @author Carlos
 * @author Isaias
 * @version 1.0
 * @since 2024
 */
public enum Posicao {
    INVALIDA(-1, -1),
    A1(0, 0),
    A2(0, 1),
    A3(0, 2),
    A4(0, 3),
    A5(0, 4),
    A6(0, 5),
    A7(0, 6),
    A8(0, 7),
    B1(1, 0),
    B2(1, 1),
    B3(1, 2),
    B4(1, 3),
    B5(1, 4),
    B6(1, 5),
    B7(1, 6),
    B8(1, 7),
    C1(2, 0),
    C2(2, 1),
    C3(2, 2),
    C4(2, 3),
    C5(2, 4),
    C6(2, 5),
    C7(2, 6),
    C8(2, 7),
    D1(3, 0),
    D2(3, 1),
    D3(3, 2),
    D4(3, 3),
    D5(3, 4),
    D6(3, 5),
    D7(3, 6),
    D8(3, 7),
    E1(4, 0),
    E2(4, 1),
    E3(4, 2),
    E4(4, 3),
    E5(4, 4),
    E6(4, 5),
    E7(4, 6),
    E8(4, 7),
    F1(5, 0),
    F2(5, 1),
    F3(5, 2),
    F4(5, 3),
    F5(5, 4),
    F6(5, 5),
    F7(5, 6),
    F8(5, 7),
    G1(6, 0),
    G2(6, 1),
    G3(6, 2),
    G4(6, 3),
    G5(6, 4),
    G6(6, 5),
    G7(6, 6),
    G8(6, 7),
    H1(7, 0),
    H2(7, 1),
    H3(7, 2),
    H4(7, 3),
    H5(7, 4),
    H6(7, 5),
    H7(7, 6),
    H8(7, 7);

    private final int linha;
    private final int coluna;

    /**
     * Construtor Posicao
     *
     * @param linha  Linha da posição no tabuleiro.
     * @param coluna Coluna da posição no tabuleiro.
     */
    Posicao(int linha, int coluna) {
        if (linha >= 0 && linha < 8 && coluna >= 0 && coluna < 8) {
            this.linha = linha;
            this.coluna = coluna;
        } else {
            this.linha = -1;
            this.coluna = -1;
        }
    }

    /**
     * Converte doi números inteiros para o tipo Posição.
     *
     * @param l  Linha.
     * @param c Coluna.
     * @return Posição.
     */
    public static Posicao toPosicao(int l, int c) {
        for (Posicao posicao : Posicao.values()) {
            if (posicao.getLinha() == l && posicao.getColuna() == c) {
                return posicao;
            }
        }

        return Posicao.INVALIDA;
    }

    /**
     * Retorna a linha da posição.
     *
     * @return Linha da posição.
     */
    public int getLinha() {
        return linha;
    }

    /**
     * Retorna a coluna da posição.
     *
     * @return Coluna da posição.
     */
    public int getColuna() {
        return coluna;
    }
}
