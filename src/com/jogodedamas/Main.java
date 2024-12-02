package com.jogodedamas;

import com.jogodedamas.controller.TabuleiroController;
import com.jogodedamas.model.TabuleiroDamas;
import com.jogodedamas.view.TabuleiroDamasView;

public class Main {
    public static void main(String[] args) {
        TabuleiroDamas tabuleiro = new TabuleiroDamas();
        TabuleiroDamasView tView = new TabuleiroDamasView();
        TabuleiroController controller = new TabuleiroController(tabuleiro, tView);

        controller.exibirTabuleiro();
    }
}
