class Ordenar {

    public static int numComparacoes;
    public static int numMovimentacoes;

    static public void trocarOrdem(Jogo[] array, int i, int j) {
        Jogo temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean comparacao(Jogo analizado, Jogo atual) {

        if (analizado.getLocal().compareTo(atual.getLocal()) > 0) {
            numComparacoes++;
            numMovimentacoes++;
            return true;
        } else if (analizado.getLocal().compareTo(atual.getLocal()) == 0) {
            if (analizado.getAno() > atual.getAno()) {
                numComparacoes++;
                numMovimentacoes++;
                return true;
            } else if (analizado.getAno() == atual.getAno()) {
                numComparacoes++;
                if (analizado.getMes() > atual.getMes()) {
                    numComparacoes++;
                    numMovimentacoes++;
                    return true;
                } else if (analizado.getMes() == atual.getMes()) {
                    numComparacoes++;
                    if (analizado.getDia() > atual.getDia()) {
                        numComparacoes++;
                        numMovimentacoes++;
                        return true;
                    } else if (analizado.getDia() == atual.getDia()) {
                        numComparacoes++;
                        numMovimentacoes++;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void mergesort(Jogo[] array, int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(array, esq, meio);
            mergesort(array, meio + 1, dir);
            intercalar(array, esq, meio, dir);
        }
    }

    private static void intercalar(Jogo[] array, int esq, int meio, int dir) {

        int n1, n2, i, j, k;

        //Definir tamanho dos dois subarrays
        n1 = meio - esq + 1;
        n2 = dir - meio;

        Jogo[] a1 = new Jogo[n1];
        Jogo[] a2 = new Jogo[n2];

        //Inicializar primeiro subarray
        for (i = 0; i < n1; i++) {
            a1[i] = array[esq + i];
        }

        //Inicializar segundo subarray
        for (j = 0; j < n2; j++) {
            a2[j] = array[meio + j + 1];
        }

        //Intercalação propriamente dita
        for (i = j = 0, k = esq; (i < n1 && j < n2); k++) {
            if (comparacao(a2[j], a1[i]))

                array[k] = a1[i++];
            else
                array[k] = a2[j++];
        }

        if (i == n1)
            for (; k <= dir; k++) {
                array[k] = a2[j++];
            }
        else
            for (; k <= dir; k++) {
                array[k] = a1[i++];
            }
    }
}
