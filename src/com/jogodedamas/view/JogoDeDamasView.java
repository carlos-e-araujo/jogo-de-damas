package com.jogodedamas.view;

import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;

import java.util.Scanner;

/**
 * Classe JogoDeDamasView
 * Representa a interface de usuário para o jogo de damas.
 *
 * <p>Esta classe é responsável por exibir informações para o jogador e solicitar entradas do jogador.</p>
 *
 * @author Carlos
 * @author Isaias
 * @version 1.0
 * @since 2024
 */
public class JogoDeDamasView {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Exibe a cor do jogador atual.
     *
     * @param corJogador A cor do jogador atual.
     */
    public void exibirJogadorAtual(Cor corJogador) {
        System.out.println("Vez das peças " + ((corJogador == Cor.BRANCO) ? "BRANCAS" : "PRETAS"));
    }

    /**
     * Solicita ao jogador a posição de uma peça no tabuleiro.
     *
     * @return A posição da peça escolhida pelo jogador.
     */
    public Posicao solicitarPeca() {
        Posicao posicao;

        System.out.print("Escolha uma peça no tabuleiro (ex: A2): ");
        posicao = Posicao.valueOf(scanner.nextLine());

        return posicao;
    }

    /**
     * Solicita ao jogador a posição para mover a peça.
     *
     * @return A posição de destino escolhida pelo jogador.
     */
    public Posicao solicitarMovimento() {
        Posicao posicao;

        System.out.print("Informe a posição que deseja mover a peça (ex: B3): ");
        posicao = Posicao.valueOf(scanner.nextLine());

        return posicao;
    }

    /**
     * Informa ao jogador que a jogada é inválida.
     */
    public void informarJogadaInvalida() {
        System.out.println("Jogada invalida.");
    }

    /**
     * Informa ao jogador o vencedor do jogo.
     *
     * @param corJogador A cor do jogador vencedor.
     */
    public void informarVencedor(Cor corJogador) {
        System.out.println("\nAs peças " + ((corJogador == Cor.BRANCO) ? "BRANCAS" : "PRETAS") + " VENCERAM!\n");
    }
}
