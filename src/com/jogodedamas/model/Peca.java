package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;

/**
 * Classe Peca
 * Representa uma peça do jogo de damas.
 */
public class Peca {
    private final Cor cor;
    private final int passo;

    /**
     * Construtor Peca
     *
     * @param cor   Cor da peça.
     * @param passo Passo (distancia maxima que ela pode se mover) da peça.
     */
    public Peca(Cor cor, int passo) {
        this.cor = cor;
        this.passo = passo;
    }

    /**
     * Retorna a cor da peça.
     *
     * @return Cor da peça.
     */
    public Cor getCor() {
        return cor;
    }

    /**
     * Retorna o passo da peça.
     *
     * @return passo da peça.
     */
    public int getPasso() {
        return passo;
    }
}
