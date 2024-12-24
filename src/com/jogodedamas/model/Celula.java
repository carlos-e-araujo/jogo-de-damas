package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;

/**
 * Classe Celula
 * Representa uma célula do tabuleiro de um jogo de damas.
 *
 * <p>Uma célula pode conter uma peça e possui uma cor (preto ou branco).</p>
 *
 * @author Carlos
 * @author Isaias
 * @version 1.0
 * @since 2024
 */
public class Celula {
    private final Cor COR;
    private Peca peca;

    /**
     * Construtor Celula
     *
     * @param cor Cor da célula.
     */
    public Celula(Cor cor) {
        this.COR = cor;
        this.peca = null;
    }

    /**
     * Retorna a cor da célula.
     *
     * @return Cor da célula.
     */
    public Cor getCor() {
        return this.COR;
    }

    /**
     * Retorna a peça presente na célula.
     *
     * @return Peça presente na célula, ou null se a célula estiver vazia.
     */
    public Peca getPeca() {
        return this.peca;
    }

    /**
     * Define a peça presente na célula.
     *
     * @param peca Peça a ser colocada na célula.
     */
    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}
