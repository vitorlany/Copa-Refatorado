class Ordenar {

    public static int numComparacoes;
    public static int numMovimentacoes;

    static public void trocarOrdem(Jogo[] array, int i, int j) {
        Jogo temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean comparacao(Jogo analizado, Jogo atual) {
        if (analizado.getAno() > atual.getAno()) { // DIA
            numComparacoes++;
            numMovimentacoes++;
            return true;
        } else if (analizado.getAno() == atual.getAno()) { // DIA
            numComparacoes++;
            if (analizado.getDia() > atual.getDia()) { // MES
                numComparacoes++;
                numMovimentacoes++;
                return true;
            } else if (analizado.getDia() == atual.getDia()) { // MES
                numComparacoes++;
                if (analizado.getMes() > atual.getMes()) { // ANO
                    numComparacoes++;
                    numMovimentacoes++;
                    return true;
                } else if (analizado.getMes() == atual.getMes()) { // ANO
                    numComparacoes++;
                    if (analizado.getSelecao1().compareTo(atual.getSelecao1()) > 0) {
                        numComparacoes++;
                        numMovimentacoes++;
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static void selecao(Jogo[] array) {
        int n = array.length;
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (comparacao(array[menor], array[j])) {
                    menor = j;
                }
            }
            Jogo temp = array[i];
            array[i] = array[menor];
            array[menor] = temp;
        }
    }

}
