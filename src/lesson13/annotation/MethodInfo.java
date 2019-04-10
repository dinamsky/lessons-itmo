package lesson13.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)

public
//TYPE
//METHOD
//FIELD
//CONSTRUCTOR
//PARAMETER
@interface MethodInfo {
    String date();
    String author();
    int version() default 1;
}
