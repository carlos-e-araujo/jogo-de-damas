package com.jogodedamas.controller;

import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.model.Tabuleiro;
import com.jogodedamas.view.JogoDeDamasView;
import com.jogodedamas.view.TabuleiroSwingView;

public class JogoDeDamasSwingController {
    private final JogoDeDamas jogoDeDamasModel;
    private final JogoDeDamasView jogoDeDamasView;
    private final TabuleiroSwingController tabuleiroController;

    public JogoDeDamasSwingController(JogoDeDamas jogoDeDamasModel, JogoDeDamasView jogoDeDamasView) {
        this.jogoDeDamasModel = jogoDeDamasModel;
        this.jogoDeDamasView = jogoDeDamasView;
        this.tabuleiroController = new TabuleiroSwingController(new Tabuleiro(), new TabuleiroSwingView());
    }

    public void iniciarJogo() {
        tabuleiroController.iniciarJogo();
    }
}
