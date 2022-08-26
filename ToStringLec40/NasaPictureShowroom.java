package ToStringLec40;

import java.util.Scanner;

public class NasaPictureShowroom {
    public void show () {
        NasaRandomPictures nasaRandomPictures = new NasaRandomPictures(); //подключаем метод поиска снимков
        System.out.println("Searching pictures...");

       NasaPicturesInfo[] pictures = nasaRandomPictures.picturesInfo(5); //получаем снимки
        System.out.println("Sound pictures: ");                          //выводим снимки
        for (int i = 0; i <pictures.length; i++ ){
            System.out.println(i + ": " + pictures[i]);
        }
        System.out.println("Witch pictures want you to see?");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();

        NasaPicturesDownloader downloader =new  NasaPicturesDownloader();  //сохраняем фото в файл
        downloader.downloadOpen(pictures[answer]);

    }
}
