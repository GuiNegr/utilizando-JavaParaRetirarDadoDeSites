package org.example.urlDownloader.ulrDownloadInterface;

import java.io.IOException;
import java.util.ArrayList;

public interface DownloadDeURLinterface {
    public void downloadPdf(ArrayList<String> linkText, ArrayList<String> nomeNovoDoArquivo) throws IOException;
}
