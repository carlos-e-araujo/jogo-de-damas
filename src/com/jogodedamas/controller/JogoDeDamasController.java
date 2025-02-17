package com.jogodedamas.controller;

import com.jogodedamas.model.JogoDeDamas;
import com.jogodedamas.utils.Cor;

public class JogoDeDamasController {
    private final JogoDeDamas model;

    public JogoDeDamasController(JogoDeDamas model) {
        this.model = model;
    }

    public Cor getCorJogadorAtual() {
        return this.model.getJogadorAtual().getCor();
    }

    public void finalizarTurno() {
        this.model.finalizarTurno();
    }
}
