class ListaEncadeada {

    private Celula primeiro;
    private Celula ultimo;
    private int tamanho;

    public ListaEncadeada() {

        Celula sentinela = new Celula();

        primeiro = sentinela;
        ultimo = sentinela;
        tamanho = 0;
    }

    public boolean listaVazia() {

        boolean resp;

        if (primeiro == ultimo)
            resp = true;
        else
            resp = false;

        return resp;
    }

    public void inserir(Jogo novo, int posicao) throws Exception {

        Celula anterior, novaCelula, proximaCelula;

        if ((posicao >= 0) && (posicao <= tamanho)) {
            anterior = primeiro;
            for (int i = 0; i < posicao; i++)
                anterior = anterior.getProximo();

            novaCelula = new Celula(novo);

            proximaCelula = anterior.getProximo();

            anterior.setProximo(novaCelula);
            novaCelula.setProximo(proximaCelula);
            novaCelula.setAnterior(anterior);
            proximaCelula.setAnterior(novaCelula);

            if (posicao == tamanho)  // a inserção ocorreu na última posição da lista
                ultimo = novaCelula;

            tamanho++;

        } else
            throw new Exception("Não foi possível inserir o item na lista: a posição informada é inválida!");
    }

    public Jogo remover(int posicao) throws Exception {

        Celula anterior, celulaRemovida, proximaCelula;

        if (! listaVazia()) {
            if ((posicao >= 0) && (posicao < tamanho)) {
                anterior = primeiro;
                for (int i = 0; i < posicao; i++)
                    anterior = anterior.getProximo();

                celulaRemovida = anterior.getProximo();


                proximaCelula = celulaRemovida.getProximo();

                anterior.setProximo(proximaCelula);
                proximaCelula.setAnterior(anterior);
                celulaRemovida.setProximo(null);
                celulaRemovida.setAnterior(null);

                if (celulaRemovida == ultimo)
                    ultimo = anterior;

                tamanho--;

                return (celulaRemovida.getItem());
            } else
                throw new Exception("Não foi possível remover o item da lista: a posição informada é inválida!");
        } else
            throw new Exception("Não foi possível remover o item da lista: a lista está vazia!");
    }

    public void inserirInicio(Jogo novo) throws Exception {
        inserir(novo, 0);
    }

    public void inserirFinal(Jogo novo) {

        Celula novaCelula;

        novaCelula = new Celula(novo);

        ultimo.setProximo(novaCelula);
        novaCelula.setAnterior(ultimo);

        ultimo = novaCelula;

        tamanho++;

    }

    public Jogo removerInicio() throws Exception {
        return remover(0);
    }

    public Jogo removerFinal() throws Exception {

        Celula removida, penultima;

        if (! listaVazia()) {

            removida = ultimo;

            penultima = ultimo.getAnterior();
            penultima.setProximo(null);
            removida.setAnterior(null);

            ultimo = penultima;

            tamanho--;

            return (removida.getItem());
        } else
            throw new Exception("Não foi possível remover o último item da lista: a lista está vazia!");
    }

    public void imprimir() throws Exception {

        Celula aux;

        if (! listaVazia()) {
            int contador = 0;

            aux = primeiro.getProximo();
            while (aux != null) {
                System.out.print("[" + contador + "]");
                aux.getItem().imprimir();
                aux = aux.getProximo();
                contador++;
            }
        } else
            throw new Exception("Não foi possível imprimir o conteúdo da lista: a lista está vazia!");
    }
}
