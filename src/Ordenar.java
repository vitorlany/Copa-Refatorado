class Ordenar {

    static public void trocarOrdem(Jogo[] array, int i, int j) {
        Jogo temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

	static public void bubblesort(Jogo[] array) {
        int n = (array.length - 1);
        for (int i = (n - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                Jogo jogoAtual = array[j];
                Jogo jogoProximo = array[j + 1];

                if (jogoAtual.getDia() > jogoProximo.getDia()) {
                    trocarOrdem(array, j, j + 1);

                } else if (jogoAtual.getDia() == jogoProximo.getDia()) {
                    if (jogoAtual.getMes() > jogoProximo.getMes()) {
                        trocarOrdem(array, j, j + 1);

                    } else if (jogoAtual.getMes() == jogoProximo.getMes()) {
                        if (jogoAtual.getAno() > jogoProximo.getAno()) {
                            trocarOrdem(array, j, j + 1);

                        } else if (jogoAtual.getAno() == jogoProximo.getAno()) {
                            if (jogoAtual.getSelecao1().compareTo(jogoProximo.getSelecao1()) > 0) {
                                trocarOrdem(array, j, j + 1);
                            }
                        }
                    }
                }
            }

        }

    }
}
