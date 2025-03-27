package org.example.compactador;

import org.example.compactador.compactInterface.CompactadorInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompactadorDeArquivos implements CompactadorInterface {

    public void compactTo(ArrayList<String> path) throws IOException {
        String zipFilePath = "/home/guilherme/Documentos/Anexo_zipado.zip";

        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zipOutputStream = new ZipOutputStream(fos)) {

            for (String filePath : path) {
                File file = new File(filePath);
                if (!file.exists()) {
                    System.out.println("Arquivo não encontrado: " + filePath);
                    continue;
                }
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    ZipEntry zipEntry = new ZipEntry(file.getName());
                    zipOutputStream.putNextEntry(zipEntry);

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                        zipOutputStream.write(buffer, 0, bytesRead);
                    }

                    zipOutputStream.closeEntry();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
