package homework5.task2;

public class Div implements Act {
    @Override
    public double execute(double x, double y) {
        if (y==0){
            System.out.println("Zero division!!!");
        return y;}
        return x/y;

    }
}
