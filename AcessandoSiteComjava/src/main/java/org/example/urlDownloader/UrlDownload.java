package org.example.urlDownloader;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class UrlDownload {

    public static void downloadPdf(String linkText, String pastaDdestino) throws IOException {
        URL url = new URL(linkText);
        InputStream in = url.openStream();
        FileOutputStream fos = new FileOutputStream(pastaDdestino);
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        in.close();
        fos.close();
    }
}
