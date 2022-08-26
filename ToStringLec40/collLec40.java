package ToStringLec40;


public class collLec40 {

    //1.У каждого класса в JAVA есть метод toString- преобразование в строку
    //2.Каждый класс в JAVA неявно наследуется в OBJECT
    //3.У каждого класса в JAVA есть метод toString
    //4.toString переопределяется для читаемого вида в консоле
    // он вызывается : Code - Override Methods-toString

    public static void main(String[] args) {
        NasaPictureShowroom showroom = new NasaPictureShowroom();
        showroom.show();
    }
}
