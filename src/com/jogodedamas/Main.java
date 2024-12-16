package com.jogodedamas;

import com.jogodedamas.jogo.Jogo;
import com.jogodedamas.jogo.JogoController;
import com.jogodedamas.jogo.JogoView;
import com.jogodedamas.tabuleiro.TabuleiroDamas;
import com.jogodedamas.tabuleiro.TabuleiroDamasController;
import com.jogodedamas.tabuleiro.TabuleiroDamasView;

public class Main {
    public static void main(String[] args) {
        JogoController jogoController = new JogoController(new Jogo(), new JogoView());
        jogoController.iniciarJogo();
    }
}
