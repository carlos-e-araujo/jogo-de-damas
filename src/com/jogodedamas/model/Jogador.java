package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;

/**
 * Classe Jogador
 * Representa um jogador no jogo de damas.
 *
 * <p>Um jogador possui uma cor que indica quais peças ele controla.</p>
 *
 * @author Carlos
 * @author Isaias
 * @version 1.0
 * @since 2024
 */
public class Jogador {
    private final Cor cor;

    /**
     * Construtor Jogador
     *
     * @param cor Cor do jogador.
     */
    public Jogador(Cor cor) {
        this.cor = cor;
    }

    /**
     * Retorna a cor do jogador.
     *
     * @return Cor do jogador.
     */
    public Cor getCor() {
        return cor;
    }
}
