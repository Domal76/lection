package ToStringLec40;

//класс информации о снимке

public class NasaPicturesInfo {
    public  String title;
    public String date;
    public String explanation;
    public String fileUrl;
    public String mediaType;

   public NasaPicturesInfo (String title, String date, String explanation, String fileUrl,  String mediaType){
        this.title = title;
        this.date = date;
        this.explanation = explanation;
        this.fileUrl = fileUrl;
        this.mediaType = mediaType;
    }
//для читаемого вида вывода в консоли переопределяем метод toString()
    //он вызывается : Code - Override Methods-toString
    @Override
    public String toString() {
        return this.mediaType + ":" + this.title + "(" + this.date + ")";
    }

    //метод для удобной читаемости(не в 1 строку в консоле)
    public String getPrettyExplanation (){
       return  this.explanation.replaceAll("[.,?!]", "\n");
    }
}
