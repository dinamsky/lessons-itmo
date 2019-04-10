package lesson13;

import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface MyAnno {
    String str() default "Тестирование";
    int val() default 9000;
}


@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos {
    MyAnno[] value();
}


class Anno {


    @MyAnno(str = "Первая аннотация", val = -1)
    @MyAnno(str = "Вторая аннотация", val = 100)

    public static void myMeth(String str, int i) {

        Anno ob = new Anno();

        try {
            Class <?> c = ob.getClass();

            Method m = c.getMethod("myMeth", String.class, int.class);

            Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
            System.out.println(anno);
        } catch (NoSuchMethodException exc) {
            System.out.println("Метод не найден.");
        }

    }

    public static void main(String args[]) {
        myMeth("тест", 10);
    }
}