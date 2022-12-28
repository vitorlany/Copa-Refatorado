public class Jogo {
    private int ano;
    private String etapa;
    private int dia;
    private int mes;
    private String selecao1;
    private int selecao1Gols;
    private int selecao2Gols;
    private String selecao2;
    private String local;

    public Jogo(String input) {
        String[] divisors = input.split("#");

        this.ano = Integer.parseInt(divisors[0]);
        this.etapa = divisors[1];
        this.dia = Integer.parseInt(divisors[2]);
        this.mes = Integer.parseInt(divisors[3]);
        this.selecao1 = divisors[4];
        this.selecao1Gols = Integer.parseInt(divisors[5]);
        this.selecao2Gols = Integer.parseInt(divisors[6]);
        this.selecao2 = divisors[7];
        this.local = divisors[8];
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "ano=" + ano +
                ", etapa='" + etapa + '\'' +
                ", dia=" + dia +
                ", mes=" + mes +
                ", selecao1='" + selecao1 + '\'' +
                ", selecao1Gols=" + selecao1Gols +
                ", selecao2Gols=" + selecao2Gols +
                ", selecao2='" + selecao2 + '\'' +
                ", local='" + local + '\'' +
                '}';
    }

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
