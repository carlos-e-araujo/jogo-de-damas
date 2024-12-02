package com.jogodetabuleiro;

public class TabuleiroView<T> {

    public void exibirTabuleiro(Tabuleiro<T> tabuleiro) {
        int linhas = tabuleiro.getLinhas();
        int colunas = tabuleiro.getColunas();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                T conteudo = tabuleiro.getCelula(i, j);

                if (conteudo == null) {
                    System.out.print(". "); // Célula vazia
                } else {
                    System.out.print(conteudo + " "); // Exibe o conteúdo da célula
                }
            }
            System.out.println();
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
