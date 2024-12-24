package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;

/**
 * Classe Dama
 * Representa uma peça dama no jogo de damas.
 *
 * <p>Uma dama pode se mover múltiplas posições em qualquer direção diagonal.</p>
 *
 * @author Carlos
 * @author Isaias
 * @version 1.0
 * @since 2024
 */
public class Dama extends Peca {
    /**
     * Construtor Dama
     *
     * @param cor Cor da peça.
     */
    public Dama(Cor cor) {
        super(cor, 7);
    }
}
