package app;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) {
        String apiUrl = "http://localhost:8080/linguagens";
        ClienteHttp httpClient = new ClienteHttp();
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

        try {
            String json = httpClient.buscaDados(apiUrl);
            List<Conteudo> conteudos = extrator.extraiConteudos(json);

            for (int i = 0; i < 3; i++) {
                Conteudo conteudo = conteudos.get(i);
                InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
                String outputFileName = String.format("saida/%s.png", conteudo.getTitulo());

                geradora.cria(inputStream, outputFileName);
                System.out.printf("%s%n%n", conteudo.getTitulo());
            }
        } catch (Exception e) {
            System.err.println("Erro durante a execução do programa:");
            e.printStackTrace();
        }
    }
}
