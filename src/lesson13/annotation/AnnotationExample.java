package lesson13.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

public class AnnotationExample {
    String name;


    @Override
    @MethodInfo(date="12/12/12", author = "user", version = 2)
    public String toString() {
        return "AnnotationExample{" +
                "name='" + name ;

    }
    @Deprecated
    @MethodInfo(date = "12456", author ="user" )
    public void someVoid(){
        System.out.println("DepreVoid");
    }

    public static void main(String[] args) {
        AnnotationExample example = new AnnotationExample();
        Method[]methods = example.getClass().getDeclaredMethods();
        for (Method method: methods){
            Annotation[] annotations = method.getDeclaredAnnotations();
            System.out.println(Arrays.toString(annotations));
            method.isAnnotationPresent(MethodInfo.class);
            MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
        }
    }
}
