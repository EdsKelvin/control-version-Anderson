package aula02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) throws IOException {

        String url = "https://pt.wikipedia.org/wiki/Incêndios_florestais_no_Havaí_em_2023"; 
        String fileName = "titulos_extraidos.txt"; // Nome do arquivo de saída

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Document doc = Jsoup.connect(url).get();
            Elements titles = doc.getElementsByTag("title"); // Extrai títulos usando a tag <title>

            for (Element title : titles) {
                String titleText = title.text();
                writer.write(titleText);
                writer.newLine(); // Pula para a próxima linha no arquivo
            }

            System.out.println("Títulos extraídos e salvos no arquivo: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
