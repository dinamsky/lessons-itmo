package homework5.task2;

public class Calc {
    private Act act;
    public Calc(Act act){
        this.act = act;
    }
    public double execute(double x,double y){
        return act.execute(x,y);
    }
}
