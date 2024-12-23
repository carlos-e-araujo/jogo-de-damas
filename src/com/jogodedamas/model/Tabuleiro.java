package com.jogodedamas.model;

import com.jogodedamas.utils.Cor;
import com.jogodedamas.utils.Posicao;

public class Tabuleiro extends com.jogodetabuleiro.Tabuleiro<Celula> {
    private static final int DIMENSAO = 8;
    private int qtdPecasBrancas = 0;
    private int qtdPecasPretas = 0;

    public Tabuleiro() {
        super(DIMENSAO, DIMENSAO);

        for (int i = 0; i < DIMENSAO; i++) {
            Cor cor = ((i % 2) == 0) ? Cor.BRANCO : Cor.PRETO;

            for (int j = 0; j < DIMENSAO; j++) {
                this.setCelula(i, j, new Celula(cor));
                cor = (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
            }
        }

        for (int i = 0; i < (super.getLinhas() / 2) - 1; i++) {
            for (int j = 0; j < super.getColunas(); j++) {
                if (super.getCelula(i, j).getCor() == Cor.PRETO) {
                    super.getCelula(i, j).setPeca(new Comum(Cor.BRANCO));
                    qtdPecasBrancas++;
                }
            }
        }

        for (int i = super.getLinhas() - 1; i > (super.getLinhas() / 2); i--) {
            for (int j = 0; j < super.getColunas(); j++) {
                if (super.getCelula(i, j).getCor() == Cor.PRETO) {
                    super.getCelula(i, j).setPeca(new Comum(Cor.PRETO));
                    qtdPecasPretas++;
                }
            }
        }
    }

    public boolean verificarMovimento(final Posicao origem, final Posicao destino, final Cor corJogador) {
        final Celula celulaOrigem = this.getCelula(origem.getLinha(), origem.getColuna());
        final Celula celulaDestino = this.getCelula(destino.getLinha(), destino.getColuna());

        if (!((destino.getLinha() >= 0) && (destino.getLinha() < this.getLinhas()) && (destino.getColuna() >= 0) && (destino.getColuna() < this.getColunas()))) {
            return false;
        }

        if (!((origem.getLinha() >= 0) && (origem.getLinha() < this.getLinhas()) && (origem.getColuna() >= 0) && (origem.getColuna() < this.getColunas()))) {
            return false;
        }

        if (celulaOrigem.getPeca() == null) {
            return false;
        }

        if (celulaDestino.getPeca() != null) {
            return false;
        }

        if (celulaOrigem.getCor() == Cor.BRANCO) {
            return false;
        }

        if (celulaDestino.getCor() == Cor.BRANCO) {
            return false;
        }

        if (verificarCaptura(origem, destino)) {
            return true;
        }

        // Impede a dama de tentar "capturar" uma peça aliada ou mais de uma peça inimiga.
        if (celulaOrigem.getPeca() instanceof Dama) {
            final int deltaLinha = destino.getLinha() - origem.getLinha();
            final int deltaColuna = destino.getColuna() - origem.getColuna();

            int linha = origem.getLinha();
            int coluna = origem.getColuna();
            int capturas = 0;

            while (linha != destino.getLinha() && coluna != destino.getColuna()) {
                linha += Integer.signum(deltaLinha);
                coluna += Integer.signum(deltaColuna);

                final Celula celulaAtual = this.getCelula(linha, coluna);

                if (celulaAtual.getPeca() != null) {
                    if (celulaAtual.getPeca().getCor() == celulaOrigem.getPeca().getCor()) {
                        return false;
                    }

                    if (celulaAtual.getPeca().getCor() != celulaOrigem.getPeca().getCor()) {
                        capturas++;

                        if (capturas > 1) {
                            return false;
                        }
                    }
                }
            }
        }

        if ((celulaOrigem.getPeca() instanceof Comum) && (celulaOrigem.getPeca().getCor() == Cor.PRETO) && !verificarCaptura(origem, destino)) {
            if (destino.getLinha() >= origem.getLinha()) {
                return false;
            }
        }

        if ((celulaOrigem.getPeca() instanceof Comum) && (celulaOrigem.getPeca().getCor() == Cor.BRANCO) && !verificarCaptura(origem, destino)) {
            if (destino.getLinha() <= origem.getLinha()) {
                return false;
            }
        }

        return celulaOrigem.getPeca().getCor() == corJogador;
    }

    public void realizarMovimento(final Posicao origem, final Posicao destino) {
        final Celula celulaOrigem = this.getCelula(origem.getLinha(), origem.getColuna());
        final Celula celulaDestino = this.getCelula(destino.getLinha(), destino.getColuna());

        celulaDestino.setPeca(celulaOrigem.getPeca());
        celulaOrigem.setPeca(null);
    }

    public boolean verificarCaptura(final Posicao origem, final Posicao destino) {
        final Celula celulaOrigem = this.getCelula(origem.getLinha(), origem.getColuna());
        final int deltaLinha = destino.getLinha() - origem.getLinha();
        final int deltaColuna = destino.getColuna() - origem.getColuna();

        if (celulaOrigem.getPeca() instanceof Dama) {
            if (Math.abs(deltaLinha) != Math.abs(deltaColuna)) {
                return false;
            }

            int linha = origem.getLinha();
            int coluna = origem.getColuna();
            int capturas = 0;

            while (linha != destino.getLinha() && coluna != destino.getColuna()) {
                linha += Integer.signum(deltaLinha);
                coluna += Integer.signum(deltaColuna);

                final Celula celulaAtual = this.getCelula(linha, coluna);

                if (celulaAtual.getPeca() != null) {
                    if (celulaAtual.getPeca().getCor() == celulaOrigem.getPeca().getCor()) {
                        return false;
                    }

                    capturas++;

                    if (capturas > 1) {
                        return false;
                    }
                }
            }

            return capturas == 1;
        } else {
            final Celula celulaCaptura = this.getCelula((origem.getLinha() + destino.getLinha()) / 2, (origem.getColuna() + destino.getColuna()) / 2);

            if (Math.abs(destino.getLinha() - origem.getLinha()) == 2 && Math.abs(destino.getColuna() - origem.getColuna()) == 2) {
                return celulaCaptura.getPeca() != null && celulaCaptura.getPeca().getCor() != celulaOrigem.getPeca().getCor();
            }

            return false;
        }
    }

    public boolean verificarPasso(final Posicao origem, final Posicao destino) {
        final Celula celulaOrigem = this.getCelula(origem.getLinha(), origem.getColuna());

        for (int i = -celulaOrigem.getPeca().getPasso(); i <= celulaOrigem.getPeca().getPasso(); i++) {
            if (((origem.getLinha() + i) == destino.getLinha()) && ((origem.getColuna() + i) == destino.getColuna())) {
                return true;
            }

            if (((origem.getLinha() + i) == destino.getLinha()) && ((origem.getColuna() - i) == destino.getColuna())) {
                return true;
            }
        }

        return false;
    }

    public void realizarCaptura(final Posicao origem, final Posicao destino) {
        final Celula celulaOrigem = this.getCelula(origem.getLinha(), origem.getColuna());
        final int deltaLinha = destino.getLinha() - origem.getLinha();
        final int deltaColuna = destino.getColuna() - origem.getColuna();

        if (celulaOrigem.getPeca() instanceof Dama) {
            int linha = origem.getLinha();
            int coluna = origem.getColuna();

            while (linha != destino.getLinha() && coluna != destino.getColuna()) {
                linha += Integer.signum(deltaLinha);
                coluna += Integer.signum(deltaColuna);

                final Celula celulaAtual = this.getCelula(linha, coluna);

                if (celulaAtual.getPeca() != null && celulaAtual.getPeca().getCor() != celulaOrigem.getPeca().getCor()) {
                    if (celulaAtual.getPeca().getCor() == Cor.PRETO) {
                        qtdPecasPretas--;
                    } else {
                        qtdPecasBrancas--;
                    }

                    celulaAtual.setPeca(null);
                    break;
                }
            }
        } else {
            final Celula celulaCaptura = this.getCelula((origem.getLinha() + destino.getLinha()) / 2, (origem.getColuna() + destino.getColuna()) / 2);

            if (celulaCaptura.getPeca().getCor() == Cor.PRETO) {
                qtdPecasPretas--;
            } else {
                qtdPecasBrancas--;
            }

            celulaCaptura.setPeca(null);
        }
    }

    public boolean verificarPromocao(final Posicao posicao) {
        final Celula celula = this.getCelula(posicao.getLinha(), posicao.getColuna());

        if (celula.getPeca().getCor() == Cor.PRETO) {
            return posicao.getLinha() == 0;
        } else {
            return posicao.getLinha() == (this.getLinhas() - 1);
        }
    }

    public void realizarPromocao(final Posicao posicao) {
        final Celula celula = this.getCelula(posicao.getLinha(), posicao.getColuna());
        celula.setPeca(new Dama(celula.getPeca().getCor()));
    }

    public boolean verificarFimDeJogo() {
        return (qtdPecasPretas <= 0) || (qtdPecasBrancas <= 0);
    }

    public int getQtdPecasBrancas() {
        return qtdPecasBrancas;
    }

    public int getQtdPecasPretas() {
        return qtdPecasPretas;
    }
}
