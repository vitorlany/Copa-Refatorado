class Jogo {
    private int ano;
    private String etapa;
    private int dia;
    private int mes;
    private String selecao1;
    private int selecao1Gols;
    private int selecao2Gols;
    private String selecao2;
    private String local;

    public Jogo(String entrada) {
        String divisoes[] = entrada.split("#");

        this.ano = Integer.valueOf(divisoes[0]);
        this.etapa = divisoes[1];
        this.dia = Integer.valueOf(divisoes[2]);
        this.mes = Integer.valueOf(divisoes[3]);
        this.selecao1 = divisoes[4];
        this.selecao1Gols = Integer.valueOf(divisoes[5]);
        this.selecao2Gols = Integer.valueOf(divisoes[6]);
        this.selecao2 = divisoes[7];
        this.local = divisoes[8];
    }

    public Jogo(int ano, String etapa, int dia, int mes, String selecao1, int selecao1Gols, int selecao2Gols, String selecao2, String local) {
        this.ano = ano;
        this.etapa = etapa;
        this.dia = dia;
        this.mes = mes;
        this.selecao1 = selecao1;
        this.selecao1Gols = selecao1Gols;
        this.selecao2Gols = selecao2Gols;
        this.selecao2 = selecao2;
        this.local = local;
    }

    public Jogo() {}

    public void imprimir() {
        String saida = String.format("[COPA %d] [%s] [%d/%d] [%s (%d) x (%d) %s] [%s]", ano, etapa, dia, mes, selecao1, selecao1Gols, selecao2Gols, selecao2, local);
        System.out.println(saida);
    }

    /* Getter and Setters */
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getSelecao1() {
        return selecao1;
    }

    public void setSelecao1(String selecao1) {
        this.selecao1 = selecao1;
    }

    public int getSelecao1Gols() {
        return selecao1Gols;
    }

    public void setSelecao1Gols(int selecao1Gols) {
        this.selecao1Gols = selecao1Gols;
    }

    public int getSelecao2Gols() {
        return selecao2Gols;
    }

    public void setSelecao2Gols(int selecao2Gols) {
        this.selecao2Gols = selecao2Gols;
    }

    public String getSelecao2() {
        return selecao2;
    }

    public void setSelecao2(String selecao2) {
        this.selecao2 = selecao2;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
