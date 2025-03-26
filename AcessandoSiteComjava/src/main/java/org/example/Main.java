package org.example;

import org.example.compactador.CompactTo;
import org.example.selenium.SeleniumSelector;
import org.example.urlDownloader.UrlDownload;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        UrlDownload.downloadPdf(
                SeleniumSelector
                        .pegarInformacao("Anexo I.","https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos"),
                "/home/guilherme/Documentos/Anexo I.pdf");

        CompactTo.compactTo("/home/guilherme/Documentos/Anexo I.pdf");
    }
}