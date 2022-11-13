import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Jogo vetorJogos[] = new Jogo[1500];
        MyIO.setCharset("UTF-8");
        carregarJogos(vetorJogos);

        ListaLinear listaJogos = new ListaLinear(1000);
        Scanner scanner = new Scanner(System.in);
        int ultimo = 0;

        String entrada = scanner.nextLine();
        while (!entrada.equals("FIM")) {
            try {
                Jogo res = compararJogos(entrada, vetorJogos);
                entrada = scanner.nextLine();
                listaJogos.inserir(res, ultimo);
                ultimo++;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        int tamanho = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < tamanho; i++) {
            entrada = scanner.nextLine();
            String comando = entrada.substring(0, 2);
            String strJogo;
            Jogo jogoInserir;
            int posicao;
            String strPosicao;
            Jogo removido;
            try {
                switch (comando) {
                    case "II":
                        strJogo = entrada.substring(3, entrada.length());
                        jogoInserir = compararJogos(strJogo, vetorJogos);
                        listaJogos.inserir(jogoInserir, 0);
                        ultimo++;
                        break;

                    case "I*":
                        strPosicao = entrada.split(" ")[1];
                        posicao = Integer.valueOf(strPosicao);
                        strJogo = entrada.substring((3 + strPosicao.length() + 1), entrada.length());
                        jogoInserir = compararJogos(strJogo, vetorJogos);
                        listaJogos.inserir(jogoInserir, posicao);
                        ultimo++;
                        break;

                    case "IF":
                        strJogo = entrada.substring(3, entrada.length());
                        jogoInserir = compararJogos(strJogo, vetorJogos);
                        listaJogos.inserir(jogoInserir, ultimo);
                        ultimo++;
                        break;

                    case "RI":
                        removido = listaJogos.remover(0);
                        System.out.print("(R) ");
                        removido.imprimir();
                        ultimo--;
                        break;

                    case "R*":
                        strPosicao = entrada.split(" ")[1];
                        posicao = Integer.valueOf(strPosicao);
                        removido = listaJogos.remover(posicao);
                        System.out.print("(R) ");
                        removido.imprimir();
                        ultimo--;
                        break;

                    case "RF":
                        removido = listaJogos.remover(ultimo-1);
                        System.out.print("(R) ");
                        removido.imprimir();
                        ultimo--;
                        break;
                }
            } catch (Exception e) {
                System.err.printf("%s : %s\n", comando, e.getMessage());
            }
        }

        try {
            listaJogos.imprimir();
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    public static Jogo compararJogos(String entrada, Jogo vetorJogos[]) throws Exception {
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
        MyIO.setCharset("UTF-8");
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

    public static void carregarJogos(Jogo vetorJogos[]) {
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
