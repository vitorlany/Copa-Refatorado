class Ordenar {

    public static int numComparacoes;
    public static int numMovimentacoes;

    static public void trocarOrdem(Jogo[] array, int i, int j) {
        Jogo temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

	public static void bubblesort(Jogo[] array) {
        int comparacoes = 0;
        int movimentacoes = 0;
        int n = (array.length - 1);
        for (int i = (n - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                Jogo jogoAtual = array[j];
                Jogo jogoProximo = array[j + 1];

                if (jogoAtual.getDia() > jogoProximo.getDia()) {
                    comparacoes++;
                    movimentacoes++;
                    trocarOrdem(array, j, j + 1);

                } else if (jogoAtual.getDia() == jogoProximo.getDia()) {
                    comparacoes++;
                    if (jogoAtual.getMes() > jogoProximo.getMes()) {
                        comparacoes++;
                        movimentacoes++;
                        trocarOrdem(array, j, j + 1);

                    } else if (jogoAtual.getMes() == jogoProximo.getMes()) {
                        comparacoes++;
                        if (jogoAtual.getAno() > jogoProximo.getAno()) {
                            comparacoes++;
                            movimentacoes++;
                            trocarOrdem(array, j, j + 1);

                        } else if (jogoAtual.getAno() == jogoProximo.getAno()) {
                            comparacoes++;
                            if (jogoAtual.getSelecao1().compareTo(jogoProximo.getSelecao1()) > 0) {
                                comparacoes++;
                                movimentacoes++;
                                trocarOrdem(array, j, j + 1);
                            }
                        }
                    }
                }
            }

        }
        numMovimentacoes = movimentacoes;
        numComparacoes = comparacoes;
    }
}
