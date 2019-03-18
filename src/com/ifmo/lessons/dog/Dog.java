package com.ifmo.lessons.dog;

public class Dog {

    private String name;
    private int height;
    private String color;
    private String adress;

    public void initialize(String name)
    {
        this.name = name;
        this.height = 40;
        this.color = "gray";
        this.adress = "street";

    }
    public void initialize(String name,int height)
    {
        this.name = name;
        this.height = height;
        this.color = "gray";
        this.adress = "street";

    }
    public void initialize(String name,int height,String color)
    {
        this.name = name;
        this.height = height;
        this.color = color;
        this.adress = "street";
    }
    public void initialize(String name,int height,String color,String adress)
    {
        this.name = name;
        this.height = height;
        this.color = color;
        this.adress = adress;
    }
}
