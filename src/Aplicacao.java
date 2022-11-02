import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Aplicacao {
    public static Jogo vetorJogos[] = new Jogo[1500];

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        carregarJogos();

        Pilha pilha = new Pilha();

        try {
            String entrada = MyIO.readLine();
            while (!entrada.equals("FIM")) {
                Jogo res = compararJogos(entrada);
                pilha.empilhar(res);
                entrada = MyIO.readLine();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        int tamanho = Integer.valueOf(MyIO.readLine());

        for (int i = 0; i < tamanho; i++) {
            String prox = MyIO.readLine();
            char comando = prox.charAt(0);

            switch (comando) {
                case 'E':
                    String separar[] = prox.split(" ");
                    try {
                        String substituir = prox.replaceAll("^E ", "");
                        Jogo empilhar = compararJogos(substituir);
                        pilha.empilhar(empilhar);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.err.println(prox);
                    }
                    break;

                case 'D':
                    try {
                        Jogo desempilhado = pilha.desempilhar();
                        System.out.print("(D) ");
                        desempilhado.imprimir();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.err.println(prox);
                    }
                    break;

                default:
                    System.err.println("Erro ao encontrar o comando!");
                    System.err.println(prox);
                    break;
            }
            
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
