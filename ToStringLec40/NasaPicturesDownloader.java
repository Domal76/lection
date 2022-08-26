package ToStringLec40;

//класс, скачивающий снимок

import java.awt.*;
import java.io.File;;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NasaPicturesDownloader {
   public void  downloadOpen (NasaPicturesInfo info){

        System.out.println("Will download " + info + "...");      //скачиваем
        System.out.println("Description: " + info.getPrettyExplanation());   //открываем

       try (InputStream in = new URL (info.fileUrl).openStream()) {
           String[]arr = info.fileUrl.split("\\."); //узнаём из URL-адреса расширение файла, делим строку в массив

           String fileExtension = arr[arr.length-1];            //узнаём последний член массива
           String fileName = "fil2" + "." +fileExtension;
           Files.copy(in, Paths.get(fileName));
           System.out.println("Pictures saved!");
           Desktop desktop = Desktop.getDesktop();
           desktop.open(new File(fileName));

       } /* catch (MalformedURLException e) {
           e.printStackTrace();
       } */catch (Exception e) {
           e.printStackTrace();
       }

   }
}
