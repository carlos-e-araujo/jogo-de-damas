package com.jogodedamas.controller;

import com.jogodedamas.model.Celula;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;
import com.jogodedamas.view.TabuleiroView;

/**
 * Classe TabuleiroController
 * Controla a lógica do tabuleiro no jogo de damas, gerenciando a interação entre o modelo e a visão.
 *
 * <p>Esta classe é responsável por exibir o tabuleiro, realizar jogadas e verificar o estado do jogo.</p>
 *
 * @author Carlos
 * @author Isaias
 * @version 1.0
 * @since 2024
 */
public class TabuleiroController extends com.jogodetabuleiro.TabuleiroController<Celula> {
    private final Tabuleiro modelTabuleiro;

    /**
     * Construtor TabuleiroController
     *
     * @param tabuleiro     O modelo do tabuleiro.
     * @param tabuleiroView A visão do tabuleiro.
     */
    public TabuleiroController(Tabuleiro tabuleiro, TabuleiroView<Celula> tabuleiroView) {
        super(tabuleiro, tabuleiroView);
        this.modelTabuleiro = (Tabuleiro) this.tabuleiro;
    }

    /**
     * Exibe o tabuleiro na visão associada.
     */
    public void exibirTabuleiro() {
        view.exibirTabuleiro(tabuleiro);
    }

    /**
     * Realiza uma jogada no tabuleiro.
     *
     * <p>Este método verifica se a jogada é válida, realiza a captura de peças se necessário,
     * move a peça e verifica se a peça deve ser promovida a dama.</p>
     *
     * @param origem     A posição inicial da peça.
     * @param destino    A posição final da peça.
     * @param corJogador A cor do jogador atual.
     * @return true se a jogada foi realizada com sucesso, false caso contrário.
     */
    public boolean realizarJogada(Posicao origem, Posicao destino, Cor corJogador) {
        if (!modelTabuleiro.verificarMovimento(origem, destino, corJogador)) {
            return false;
        }

        if (modelTabuleiro.verificarCaptura(origem, destino)) {
            modelTabuleiro.realizarCaptura(origem, destino);
        } else if (!modelTabuleiro.verificarPasso(origem, destino)) {
            return false;
        }

        modelTabuleiro.realizarMovimento(origem, destino);

        if (modelTabuleiro.verificarPromocao(destino)) {
            modelTabuleiro.realizarPromocao(destino);
        }

        return true;
    }

    /**
     * Verifica se o jogo chegou ao fim.
     *
     * @return true se o jogo chegou ao fim, false caso contrário.
     */
    public boolean verificarFimDeJogo() {
        return modelTabuleiro.verificarFimDeJogo();
    }

    /**
     * Retorna a cor do jogador com mais peças no tabuleiro.
     *
     * @return A cor do jogador com mais peças.
     */
    public Cor getCorComMaisPecas() {
        return (modelTabuleiro.getQtdPecasBrancas() > modelTabuleiro.getQtdPecasPretas()) ? Cor.BRANCO : Cor.PRETO;
    }
}
