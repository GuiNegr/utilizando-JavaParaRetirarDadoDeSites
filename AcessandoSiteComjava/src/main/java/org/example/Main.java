package org.example;

import org.example.automaizadorDeDownload.DownloadAutomatizadoDeLinks;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        DownloadAutomatizadoDeLinks downloadAutomatizadoDeLinks = new DownloadAutomatizadoDeLinks();
        downloadAutomatizadoDeLinks.download();
    }
}