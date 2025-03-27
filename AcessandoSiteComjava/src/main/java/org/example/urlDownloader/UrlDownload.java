package org.example.urlDownloader;
import org.example.urlDownloader.ulrDownloadInterface.DownloadDeURLinterface;

import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class UrlDownload implements DownloadDeURLinterface {

    public void downloadPdf(ArrayList<String> linkText, ArrayList<String> nomeNovoDoArquivo) throws IOException {
        int contador = 0;
        while (contador < linkText.size()) {
            URL url = new URL(linkText.get(contador));
            InputStream in = url.openStream();
            FileOutputStream fos = new FileOutputStream(nomeNovoDoArquivo.get(contador));
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            in.close();
            fos.close();
            contador++;
        }
    }
}
