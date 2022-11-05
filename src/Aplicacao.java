import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Aplicacao {
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
        //Ordenar.bubblesort(vetorOrdenado);
        Ordenar.mergesort(vetorOrdenado, 0, vetorOrdenado.length - 1);
        long tempoFinal = System.currentTimeMillis() - tempoInicial;
        for (int i = 0; i < vetorOrdenado.length; i++) {
            vetorOrdenado[i].imprimir();
        }

        try {
            File log = new File("1386402_mergesort.txt");
            String str = String.format("1386402\t%d\t%d\t%d", tempoFinal, Ordenar.numComparacoes, Ordenar.numMovimentacoes);
            BufferedWriter writer = new BufferedWriter(new FileWriter("1386402_mergesort.txt"));
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
            File dataBase = new File("./src/tmp/partidas.txt");
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
