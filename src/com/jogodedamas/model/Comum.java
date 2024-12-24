package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;

/**
 * Classe Comum
 * Representa uma peça comum no jogo de damas.
 *
 * <p>Uma peça comum pode se mover apenas uma posição por vez.</p>
 *
 * @author Carlos
 * @author Isaias
 * @version 1.0
 * @since 2024
 */
public class Comum extends Peca {
    /**
     * Construtor Comum
     *
     * @param cor Cor da peça.
     */
    public Comum(Cor cor) {
        super(cor, 1);
    }
}
