package com.ifmo.lessons.cat;

public class Cat {

        private static final int TERMINATION_AGE = 8;
        private String name;
        private int age;
        private int weight;
        private int power;
        private int fearIndex;

        public Cat(String name, int age, int weight, int power) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.power = power;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", power=" + power +

                '}';
    }

    public int getTotalPower(){
            fearIndex = ((age > TERMINATION_AGE)? TERMINATION_AGE-age : age) * weight;
            int totalPower = power*fearIndex;
            return totalPower;
        }


}
