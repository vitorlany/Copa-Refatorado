import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Bubblesort {
    public static Jogo vetorJogos[] = new Jogo[1500];

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        carregarJogos();

        Scanner scanner = new Scanner(System.in);

        int tamanho = Integer.valueOf(scanner.nextLine());
        Jogo vetorOrdenado[] = new Jogo[tamanho];

        try {
            for (int i = 0; i < tamanho; i++) {
                String entrada = scanner.nextLine();
                Jogo resp = compararJogos(entrada);
                vetorOrdenado[i] = resp;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        long tempoInicial = System.currentTimeMillis();
        Ordenar.bubblesort(vetorOrdenado);
        long tempoFinal = System.currentTimeMillis() - tempoInicial;
        for (int i = 0; i < vetorOrdenado.length; i++) {
            vetorOrdenado[i].imprimir();
        }

        try {
            File log = new File("1386402_bolha.txt");
            String str = String.format("1386402\t%d\t%d\t%d", tempoFinal, Ordenar.numComparacoes, Ordenar.numMovimentacoes);
            BufferedWriter writer = new BufferedWriter(new FileWriter("1386402_bolha.txt"));
            writer.write(str);
            //System.out.println(str);
            writer.close();
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }

    public static Jogo compararJogos(String entrada) throws Exception {
        /*try {
        // Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        // Esse tipo de scanner tambem funciona!!!
            String entrada = MyIO.readLine();
            while (!entrada.equals("FIM")) {
                Jogo res = compararJogos(entrada);
                res.imprimir();
                entrada = MyIO.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        String vetorEntrada[] = entrada.split("/|;");
        Boolean parar = false;
        Jogo res = new Jogo();
        for (int i = 0; (vetorJogos[i] != null && !parar); i++ ) {
            Jogo jogo = vetorJogos[i];
            if (jogo.getSelecao1().equals(vetorEntrada[3])) {
                int dia = Integer.valueOf(vetorEntrada[0]);
                int mes = Integer.valueOf(vetorEntrada[1]);
                int ano = Integer.valueOf(vetorEntrada[2]);
                if (dia == jogo.getDia() && mes == jogo.getMes() && ano == jogo.getAno()) {
                    parar = true;
                    res = jogo;
                }
            }

        }
        if (! parar) {
            throw new Exception("Não encontrado!");
        }
        return res;
    }

    public static void carregarJogos() {
        MyIO.setCharset("UTF-8");
        try {
            File dataBase = new File("/tmp/partidas.txt");
            Scanner scanner = new Scanner(dataBase);
            for (int i = 0; scanner.hasNextLine(); i++) {
                String proximo = scanner.nextLine();
                vetorJogos[i] = new Jogo(proximo);
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

class Ordenar {

    public static int numComparacoes;
    public static int numMovimentacoes;

    static public void trocarOrdem(Jogo[] array, int i, int j) {
        Jogo temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static boolean comparacao(Jogo analizado, Jogo atual) {
        if (analizado.getDia() > atual.getDia()) { // ANO
            numComparacoes++;
            numMovimentacoes++;
            return true;
        } else if (analizado.getDia() == atual.getDia()) { // ANO
            numComparacoes++;
            if (analizado.getMes() > atual.getMes()) { // MES
                numComparacoes++;
                numMovimentacoes++;
                return true;
            } else if (analizado.getMes() == atual.getMes()) { // MES
                numComparacoes++;
                if (analizado.getAno() > atual.getAno()) { // DIA
                    numComparacoes++;
                    numMovimentacoes++;
                    return true;
                } else if (analizado.getAno() == atual.getAno()) { // DIA
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

    public static void bubblesort(Jogo[] array) {
        int n = array.length;
        for (int i = (n - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                Jogo jogoAtual = array[j];
                Jogo jogoProximo = array[j + 1];

                if (comparacao(jogoAtual, jogoProximo)) {
                    trocarOrdem(array, j, j + 1);
                }
            }

        }
    }
}
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
