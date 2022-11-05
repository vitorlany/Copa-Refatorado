class Ordenar {

    public static int numComparacoes;
    public static int numMovimentacoes;

    static public void trocarOrdem(Jogo[] array, int i, int j) {
        Jogo temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean comparacao(Jogo analizado, Jogo atual) {
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
                    if (analizado.getEtapa().compareTo(atual.getEtapa()) > 0) {
                        numComparacoes++;
                        numMovimentacoes++;
                        return true;
                    } else if (analizado.getEtapa().compareTo(atual.getEtapa()) == 0) {
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
        }
        return false;
    }

    public static void sort(Jogo[] array) {
        int n = array.length;
        quicksort(array, 0, n - 1);
    }

    private static void quicksort(Jogo[] array, int esq, int dir) {

        int part;
        if (esq < dir){
            part = particao(array, esq, dir);
            quicksort(array, esq, part - 1);
            quicksort(array, part + 1, dir);
        }
    }

    private static int particao(Jogo[] array, int inicio, int fim) {

        Jogo pivot = array[fim];
        int part = inicio - 1;
        for (int i = inicio; i < fim; i++) {
            if (comparacao(pivot, array[i])) {
                part++;
                swap(array, part, i);
            }
        }
        part++;
        swap(array, part, fim);
        return (part);
    }

    private static void swap(Jogo[] array, int i, int j) {
        Jogo temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
