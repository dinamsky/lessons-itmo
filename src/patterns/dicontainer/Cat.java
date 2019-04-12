package patterns.dicontainer;

import patterns.dicontainer.di.Config;

@Config
public class Cat {
    private String catName;
    public Cat(){
        System.out.println("Cat init");
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catName='" + catName + '\'' +
                '}';
    }
}
