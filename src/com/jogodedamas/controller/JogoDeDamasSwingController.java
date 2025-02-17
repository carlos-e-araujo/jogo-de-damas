package com.jogodedamas.controller;

import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.utils.Cor;

public class JogoDeDamasSwingController {
    private final JogoDeDamas jogoDeDamasModel;

    public JogoDeDamasSwingController(JogoDeDamas jogoDeDamasModel) {
        this.jogoDeDamasModel = jogoDeDamasModel;
    }

    public Cor getCorJogadorAtual() {
        return this.jogoDeDamasModel.getJogadorAtual().getCor();
    }

    public void finalizarTurno() {
        this.jogoDeDamasModel.finalizarTurno();
    }
}
