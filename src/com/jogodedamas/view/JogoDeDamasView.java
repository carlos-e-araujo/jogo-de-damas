package com.jogodedamas.view;

import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;

import java.util.Scanner;

public class JogoDeDamasView {
    private final Scanner scanner = new Scanner(System.in);

    public void exibirJogadorAtual(Cor corJogador) {
        System.out.println("Vez das peças " + ((corJogador == Cor.BRANCO) ? "BRANCAS" : "PRETAS"));
    }

    public Posicao solicitarPeca() {
        Posicao posicao;

        System.out.print("Escolha uma peça no tabuleiro (ex: A2): ");
        posicao = Posicao.valueOf(scanner.nextLine());

        return posicao;
    }

    public Posicao solicitarMovimento() {
        Posicao posicao;

        System.out.print("Informe a posição que deseja mover a peça (ex: B3): ");
        posicao = Posicao.valueOf(scanner.nextLine());

        return posicao;
    }

    public void informarJogadaInvalida() {
        System.out.println("Jogada invalida.");
    }

    public void informarVencedor(Cor corJogador) {
        System.out.println("\nAs peças " + ((corJogador == Cor.BRANCO) ? "BRANCAS" : "PRETAS") + " VENCERAM!\n");
    }
}
