class Celula {
    Jogo item;
    Celula proximo;
    Celula anterior;

    public Celula() { // Criando satélite;
        item = new Jogo();
        proximo = null;
    }

    public Celula (Jogo novo) {
        item = novo;
        proximo = null;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    public Jogo getItem() {
        return item;
    }

    public void setItem(Jogo item) {
        this.item = item;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }

    public Celula getProximo() {
        return proximo;
    }
}