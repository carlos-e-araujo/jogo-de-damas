package com.jogodedamas;

import com.jogodedamas.cor.Cor;

import java.util.Scanner;

public class JogoDeDamasView {
    Scanner scanner = new Scanner(System.in);

    public void exibirJogadorAtual(Cor corJogador) {
        System.out.println("Vez do jogador " + ((corJogador == Cor.BRANCO) ? "Branco" : "Preto"));
    }

    public int[] solicitarPeca() {
        int[] pos = new int[2];

        System.out.println("Escolha uma peça no tabuleiro");
        System.out.print("Linha: ");
        pos[0] = scanner.nextInt();

        System.out.print("Coluna: ");
        pos[1] = scanner.nextInt();

        return pos;
    }

    public int[] solicitarMovimento() {
        int[] pos = new int[2];

        System.out.println("Informe a posição que deseja mover a peça");

        System.out.print("Linha: ");
        pos[0] = scanner.nextInt();

        System.out.print("Coluna: ");
        pos[1] = scanner.nextInt();

        return pos;
    }
}
