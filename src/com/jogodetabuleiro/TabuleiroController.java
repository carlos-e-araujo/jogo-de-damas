package com.jogodetabuleiro;

public class TabuleiroController<T> {
    protected final Tabuleiro<T> tabuleiro;
    protected final TabuleiroView<T> view;

    public TabuleiroController(Tabuleiro<T> tabuleiro, TabuleiroView<T> view) {
        this.tabuleiro = tabuleiro;
        this.view = view;
    }

    public void iniciarJogo() {
        view.mostrarMensagem("Jogo iniciado!");
        view.exibirTabuleiro(tabuleiro);
    }

    public void realizarJogada(int linha, int coluna, T valor) {
        if (linha >= 0 && linha < tabuleiro.getLinhas() && coluna >= 0 && coluna < tabuleiro.getColunas()) {
            tabuleiro.setCelula(linha, coluna, valor);
            view.exibirTabuleiro(tabuleiro);
        } else {
            view.mostrarMensagem("Jogada inválida. Tente novamente.");
        }
    }

    public void finalizarJogo() {
        view.mostrarMensagem("Jogo finalizado!");
    }
}
