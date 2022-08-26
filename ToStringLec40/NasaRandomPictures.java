package ToStringLec40;

//класс возвращает случайные снимки (поисковик)

import utils.PageDownloader;
import utils.RandomDateGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class NasaRandomPictures {
   public NasaPicturesInfo[] picturesInfo (int count) {
       NasaPicturesInfo[] arr = new NasaPicturesInfo[count];
       for (int i = 0; i < count; i++) {
           String date = getRandomDateStr();               //определяем случайную дату
           String url = "https://api.nasa.gov/planetary/apod?api_key=VaH3fUZa1uViHDCgVOUuQWRq3tUPuMmdBbxgSp0H&date=" + date;

           PageDownloader downloader = new PageDownloader();    //класс с методом скачивания по веб адресу
           String page = downloader.downloadWebPage(url);

           String explanation = getTagValue(page, "explanation");
           String hdUrl = getTagValue(page, "hdurl");
           String mediaType = getTagValue(page, "media_type");
           String title = getTagValue(page, "title");

              //присваеваем данные аргументам конструктора из класса NasaPicturesInfo
           NasaPicturesInfo info = new NasaPicturesInfo(title,date,explanation,hdUrl,mediaType);
           arr[i]= info;
       }
           return arr;

   }
   private String getTagValue (String page, String tagName) {      //находим теги
       int begin = page.indexOf('"' + tagName + '"') +4 +tagName.length();
       int end = page.indexOf('"', begin);
       String subStr = page.substring(begin,end);
       return subStr;
   }

    private String getRandomDateStr() {                                   //метод случайных чисел
        RandomDateGenerator randomDateGenerator = new RandomDateGenerator();
        LocalDate randomDate = randomDateGenerator.getRandomDate(2000, 2021);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateStr = randomDate.format(formatter);
        return dateStr;
    }
    //метод для превращения двузначного числа, если сгенерируется однозначное
   // private String addZerro(int randomMonth) {
      //  return randomMonth < 10 ? "0" + randomMonth : String.valueOf(randomMonth);
    }


