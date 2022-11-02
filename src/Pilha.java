class Pilha {
    private Celula fundo;
    private Celula topo;

    public Pilha() {
        Celula sentinela = new Celula();
        topo = sentinela;
        fundo = sentinela;
    }

    public boolean pilhaVazia() {
        if (topo == fundo) {
            return true;
        }
        return false;
    }

    public void empilhar(Jogo novo) {
        Celula novaCelula = new Celula(novo);
        novaCelula.setProximo(topo);
        topo = novaCelula;
    }

    public Jogo desempilhar() throws Exception {
        if (! pilhaVazia()) {
            Celula desempilhado = topo;
            topo = topo.getProximo();
            desempilhado.setProximo(null);
            return desempilhado.getItem();
        } else {
            throw new Exception("Pilha vazia!");
        }
    }

    public void mostrar() {
        int ref = 1;
        Celula referencia = topo;
        do {
            System.out.printf("["+ ref +"]");
            referencia.getItem().imprimir();
            referencia = referencia.getProximo();
            ref++;
        } while (referencia != fundo);
    }
}
