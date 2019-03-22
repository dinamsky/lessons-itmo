package hospital;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int choice = 0;
        int patientAge;
        String patientName;
        String doctorSpeciality;

        Doctor o = new Doctor("Василий Теркин","Ревматолог");
        Doctor o1 = new Doctor("Антон Петров","Психиатр");
        Doctor o2 = new Doctor("Николай Ковындря","Онколог");
        Hospital h1 = new Hospital();
        h1.addDoctor(o);
        h1.addDoctor(o1);
        h1.addDoctor(o2);
do{
        System.out.println("Нажмите 1 чтобы посомтреть список врачей нашей больницы\nНажмите 2 чтобы добавить пациента" +
                " - записаться ко врачу \nAдминистратор введите пин-код\nДля выхода нажмите 0");
        Scanner in = new Scanner(System.in);
        choice = in.nextInt();
        switch (choice){
            case 1:{
                System.out.println(h1.showDoctors());
        }
            case 2:{
                System.out.println("Добавляем пациентов");
                Patient p = new Patient("Вася",8);
                Patient p1 = new Patient("Петя",43);
                Patient p2 = new Patient("Андрей",59);


               ;



            }
            case 1981:{
                System.out.println("Нажмите 1 чтобы посмотреть врачей и их записи\nДля выхода нажмите 0");
                choice = in.nextInt();
                do{
                switch (choice){
                    case 1:{

                        System.out.println(h1.showPatients());

                        System.out.println();
                    }
                }} while (choice!=0);
            }

    }} while(choice!=0);
}}
