package com.jogodetabuleiro;

/**
 * Classe Tabuleiro
 * Representa um tabuleiro genérico para jogos, permitindo manipulação de células de qualquer tipo.
 *
 * <p>A classe é projetada para ser reutilizável em diferentes jogos,
 * como Jogo da Velha ou Damas, fornecendo operações básicas para
 * acessar e modificar as células.</p>
 *
 * @param <T> O tipo de dados armazenado em cada célula do tabuleiro.
 *
 * @author [Seu Nome]
 * @version 1.0
 * @since 2024
 */
public class Tabuleiro<T> {
    private T[][] celulas;

    /**
     * Construtor Tabuleiro.
     *
     * <p>Inicializa o tabuleiro com o número especificado de linhas e colunas.</p>
     *
     * @param linhas O número de linhas do tabuleiro.
     * @param colunas O número de colunas do tabuleiro.
     * @throws IllegalArgumentException Se o número de linhas ou colunas for menor ou igual a zero.
     */
    @SuppressWarnings("unchecked")
    public Tabuleiro(int linhas, int colunas) {
        if (linhas <= 0 || colunas <= 0) {
            throw new IllegalArgumentException("Linhas e colunas devem ser maiores que zero.");
        }
        celulas = (T[][]) new Object[linhas][colunas];
    }

    /**
     * Obtém o valor de uma célula específica do tabuleiro.
     *
     * @param linha A linha da célula desejada (índice começando em 0).
     * @param coluna A coluna da célula desejada (índice começando em 0).
     * @return O valor armazenado na célula, ou {@code null} se a célula estiver vazia.
     * @throws ArrayIndexOutOfBoundsException Se a linha ou coluna estiver fora dos limites do tabuleiro.
     */
    public T getCelula(int linha, int coluna) {
        return celulas[linha][coluna];
    }

    /**
     * Define o valor de uma célula específica do tabuleiro.
     *
     * @param linha A linha da célula a ser atualizada (índice começando em 0).
     * @param coluna A coluna da célula a ser atualizada (índice começando em 0).
     * @param valor O valor a ser atribuído à célula.
     * @throws ArrayIndexOutOfBoundsException Se a linha ou coluna estiver fora dos limites do tabuleiro.
     */
    public void setCelula(int linha, int coluna, T valor) {
        celulas[linha][coluna] = valor;
    }

    /**
     * Retorna o número total de linhas do tabuleiro.
     *
     * @return O número de linhas do tabuleiro.
     */
    public int getLinhas() {
        return celulas.length;
    }

    /**
     * Retorna o número total de colunas do tabuleiro.
     *
     * @return O número de colunas do tabuleiro.
     */
    public int getColunas() {
        return celulas[0].length;
    }
}
