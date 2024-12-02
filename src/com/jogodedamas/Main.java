package com.jogodedamas;

import com.jogodedamas.controller.TabuleiroDamasController;
import com.jogodedamas.model.TabuleiroDamas;
import com.jogodedamas.view.TabuleiroDamasView;

public class Main {
    public static void main(String[] args) {
        TabuleiroDamas tModel = new TabuleiroDamas();
        TabuleiroDamasView tView = new TabuleiroDamasView();
        TabuleiroDamasController controller = new TabuleiroDamasController(tModel, tView);

        controller.exibirTabuleiro();
    }
}
