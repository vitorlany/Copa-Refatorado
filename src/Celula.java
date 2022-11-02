class Celula {
    Jogo item;
    Celula proximo;

    public Celula() { // Criando satélite;
        item = new Jogo();
        proximo = null;
    }

    public Celula (Jogo novo) {
        item = novo;
        proximo = null;
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