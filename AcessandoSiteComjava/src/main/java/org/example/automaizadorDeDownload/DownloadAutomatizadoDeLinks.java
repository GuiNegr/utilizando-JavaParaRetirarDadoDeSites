package org.example.automaizadorDeDownload;

import org.example.automaizadorDeDownload.interfaceAutomatizadorDownload.InterfaceDownloadAutomatizado;
import org.example.compactador.CompactadorDeArquivos;
import org.example.compactador.compactInterface.CompactadorInterface;
import org.example.selenium.SeleniumSelector;
import org.example.selenium.interfaces.SeleniumSelectorInterfaces;
import org.example.urlDownloader.UrlDownload;
import org.example.urlDownloader.ulrDownloadInterface.DownloadDeURLinterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DownloadAutomatizadoDeLinks implements InterfaceDownloadAutomatizado {
    private ArrayList<String> links;
    private Scanner scanner;

    public DownloadAutomatizadoDeLinks() {
        links = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    private void pegaLinkDownload() {
        System.out.println("Quantos Downloads serão?");
        int opcao = scanner.nextInt();

        for (int i = 0; i < opcao; i++) {
            System.out.println("Informe o link de download");
            String path = scanner.next();

            scanner = new Scanner(System.in);

            System.out.println("Informe o nome da tag html: ex Anexo I.");
            String link = scanner.nextLine();

            SeleniumSelectorInterfaces sel = new SeleniumSelector();
            links.add(sel.pegarInformacao(link, path));
        }
    }


    public void download() throws IOException {
        scanner = new Scanner(System.in);
        pegaLinkDownload();
        ArrayList<String> pastasDeDestinos = new ArrayList<>();
        for (int i = 0; i < links.size(); i++) {
            System.out.println("Informe a pasta de destino: ");
            String pasta = scanner.nextLine();
            pastasDeDestinos.add(pasta);
        }
        DownloadDeURLinterface urlDownload = new UrlDownload();
        urlDownload.downloadPdf(this.links,pastasDeDestinos);
        CompactadorInterface compact = new CompactadorDeArquivos();
        compact.compactTo(pastasDeDestinos);
    }
}
