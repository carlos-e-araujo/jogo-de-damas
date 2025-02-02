package com.jogodedamas.controller;

import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;
import com.jogodedamas.view.JogoDeDamasView;
import com.jogodedamas.view.TabuleiroView;

/**
 * Classe JogoDeDamasController
 * Controla a lógica do jogo de damas, gerenciando a interação entre o modelo e a visão.
 *
 * <p>Esta classe é responsável por iniciar o jogo, gerenciar turnos, verificar jogadas e determinar o vencedor.</p>
 *
 * @author Carlos
 * @author Isaias
 * @version 1.0
 * @since 2024
 */
public class JogoDeDamasController {
    private final JogoDeDamas jogoDeDamasModel;
    private final JogoDeDamasView jogoDeDamasView;
    private final TabuleiroController tabuleiroController;

    /**
     * Construtor JogoDeDamasController
     *
     * @param jogoDeDamasModel O modelo do jogo de damas.
     * @param jogoDeDamasView  A visão do jogo de damas.
     */
    public JogoDeDamasController(JogoDeDamas jogoDeDamasModel, JogoDeDamasView jogoDeDamasView) {
        this.jogoDeDamasModel = jogoDeDamasModel;
        this.jogoDeDamasView = jogoDeDamasView;
        this.tabuleiroController = new TabuleiroController(new Tabuleiro(), new TabuleiroView<>());
    }

    /**
     * Inicia o jogo de damas.
     *
     * <p>Este método exibe o tabuleiro, solicita jogadas dos jogadores e alterna os turnos até que o jogo termine.</p>
     */
    public void iniciarJogo() {
        Posicao origem = null;
        Posicao destino = null;

        tabuleiroController.iniciarJogo();

        while (!tabuleiroController.verificarFimDeJogo()) {
            final Cor corJogadorAtual = jogoDeDamasModel.getJogadorAtual().getCor();

            this.jogoDeDamasView.exibirJogadorAtual(corJogadorAtual);
            tabuleiroController.exibirTabuleiro();

            while (origem == null || origem == Posicao.INVALIDA) {
                origem = jogoDeDamasView.solicitarPeca();
            }

            while (destino == null || destino == Posicao.INVALIDA) {
                destino = jogoDeDamasView.solicitarMovimento();
            }

            if (tabuleiroController.realizarJogada(origem, destino, corJogadorAtual)) {
                jogoDeDamasModel.finalizarTurno();
            } else {
                jogoDeDamasView.informarJogadaInvalida();
            }
        }

        jogoDeDamasView.informarVencedor(tabuleiroController.getCorComMaisPecas());
        tabuleiroController.exibirTabuleiro();
        tabuleiroController.finalizarJogo();
    }
}
