package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;

/**
 * Classe JogoDeDamas
 * Representa uma partida de jogo de damas.
 *
 * <p>Esta classe gerencia os jogadores e alterna os turnos entre eles.</p>
 *
 * @author Carlos
 * @author Isaias
 * @version 1.0
 * @since 2024
 */
public class JogoDeDamas {
    private final Jogador jogadorB;
    private final Jogador jogadorP;
    private Jogador jogadorAtual;

    /**
     * Construtor JogoDeDamas
     *
     * <p>Inicializa os jogadores e define o jogador branco como o jogador inicial.</p>
     */
    public JogoDeDamas() {
        this.jogadorP = new Jogador(Cor.PRETO);
        this.jogadorB = new Jogador(Cor.BRANCO);
        this.jogadorAtual = this.jogadorB;
    }

    /**
     * Finaliza o turno atual e alterna para o próximo jogador.
     */
    public void finalizarTurno() {
        this.jogadorAtual = (this.jogadorAtual == this.jogadorB) ? this.jogadorP : this.jogadorB;
    }

    /**
     * Retorna o jogador atual.
     *
     * @return O jogador atual.
     */
    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }
}
