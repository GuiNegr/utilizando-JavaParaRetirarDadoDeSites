package org.example.compactador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompactTo {


    //Tem que terminar esse codigo não está fazendo oque era suposto
    public static void compactTo(String path){
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("arquivo.zip");
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            zipOutputStream.putNextEntry(new ZipEntry(path));

            int content;
            while((content = fileInputStream.read()) != -1){
                zipOutputStream.write(content);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
