package lesson7.homework;

public class Main {

    public static void main(String[] args) {


        Pupil pupil = new Pupil(123);
        String[] ex = {"История","Французский язык"};
        int[] marks = { 1, 5 };

        pupil.setExams(ex, marks);
        System.out.println(pupil);


    }
}

