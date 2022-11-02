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
        if (! pilhaVazia()) {
            int i = 0;
            Celula ref = topo;
            while (ref.getProximo() != fundo) {
                System.out.print("[" + i + "]");
                ref.getItem().imprimir();
                ref = ref.getProximo();
                i++;
            }
        }
    }
}
