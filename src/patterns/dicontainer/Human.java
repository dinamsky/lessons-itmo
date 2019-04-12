package patterns.dicontainer;

import patterns.dicontainer.di.AutoRun;
import patterns.dicontainer.di.Autofield;
import patterns.dicontainer.di.Component;

@Component
public class Human {
    Dog dog;
    @Autofield
    Cat cat;

    public Human() {
        System.out.println("human init");
    }
    @AutoRun
    public void walkWithCat(){
        System.out.println("walk with "+ cat.getCatName());
    }

}
