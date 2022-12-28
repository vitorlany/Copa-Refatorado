import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Jogo> jogos = new LinkedList<>();
        try {
            lerArquivo(jogos, "partidas.txt");
            for (Jogo jogo : jogos) {
                System.out.println(jogo);
            }
        } catch (IOException e) {
            System.err.println("Arquivo não encontrado!");
            e.printStackTrace();
        }
    }

    public static void lerArquivo(List<Jogo> jogos, String file) throws IOException {
        Path path = Paths.get("src\\tmp", file);
        try (FileReader fileReader = new FileReader(path.toFile())) {
            BufferedReader reader = new BufferedReader(fileReader);
            String linha;
            while ((linha = reader.readLine()) != null) {
                Jogo newJogo = new Jogo(linha);
                jogos.add(newJogo);
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }
}