package controller;

import model.Jogo;
import view.JogoView;

public class JogoController {
    private Jogo jogoModel;
    private JogoView jogoView;

    public JogoController(Jogo jogoModel, JogoView jogoView) {
        this.jogoModel = jogoModel;
        this.jogoView = jogoView;
    }

    public String receberMovimento(String entrada) {
        // TODO: receberMovimento
        return null;
    }

    public void proximoTurno() {
        // TODO: proximoTurno
    }

    public void jogar() {
        // TODO: jogar
    }
}
