package lambda;

import blockchain.Block;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {
    //@predicate
    // func: boolean test(T t);
    // default func:
    // and(Predicate other);
    public static void main(String[] args) {


        Predicate<Integer> sec = (num) -> num < 0;
        Predicate<Integer> pos = (num) -> num > 9;
        Function<Integer, String> convert = a -> a + "$";

        Predicate<Integer> condition = num->num>0;
        Function<Integer,Integer> ifTrue = a->a+10;



    }


}
