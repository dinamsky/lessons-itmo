package lesson6.classwork.staticFinal;

public final class CalcUtils {
    // статические свойства


    // статические блоки - для объявления стат переменных
    static {
        final double PI = 3.1415;
       final double E = 2.7;
    }


    // статические методы
    public static double sum(int a, int b){
        return a+b;
    }
    // final и static нельзя переопределять Override в дочерних классах
    // final аргументы доступны только для чтения в методе
    public final void someVoid(final int a){};
}
//class Utils extends CalcUtils{


