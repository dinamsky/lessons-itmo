package lesson9.homework;

import java.util.*;

public class Person {
    private String name;
    private int age;
    private int salary;
    private String company;

    public Person(){}

    public Person(String name, int age, int salary, String company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Name: " + name  + " Age: " + age + " Salary: "  + salary + " Company: " + company;
    }
}


class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>(PersonGenerator.generate(5));


        Comparator<Person> comparator1 = new NameComparator();
        Collections.sort(list, comparator1);

        for (Person person : list) {
            System.out.println(person);
        }

        System.out.println();

        Comparator<Person> comparator2 = new NameComparator().thenComparing(new SalaryComparator());
        Collections.sort(list, comparator2);

        for (Person person : list) {
            System.out.println(person);
        }

        System.out.println();

        Comparator<Person> comparator3 = new NameComparator().thenComparing(new SalaryComparator()).thenComparing(new AgeComparator()).thenComparing(new CompanyComparator());
        Collections.sort(list, comparator3);

        for (Person person : list) {
            System.out.println(person);
        }

    }
}



class NameComparator implements Comparator<Person>{


    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


class SalaryComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getSalary() - o2.getSalary();
    }
}


class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge() ;
    }
}


class CompanyComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}






class PersonGenerator {

    public static List<Person> generate(int num){
        Random random = new Random();
        List<Person> list = new ArrayList<>(num);
        int nameCount = Name.values().length;
        int companyCount = Company.values().length;
        int ageMax = 65;
        int ageMin = 18;
        int salaryMax = 200000;
        int salaryMin = 10000;
        for(int i = 0; i < num; i++){
            Person person = new Person();
            String name = Name.values()[random.nextInt(nameCount)].toString();
            String company = Company.values()[random.nextInt(companyCount)].toString();
            int age = random.nextInt(ageMax - ageMin + 1) + ageMin;
            int salary = random.nextInt(salaryMax - salaryMin + 1) + salaryMin;
            person.setName(name);
            person.setCompany(company);
            person.setAge(age);
            person.setSalary(salary);
            list.add(person);
        }
        return list;
    }




}

enum Name{
    Луис, Анастас, Владимир, Марк, Антон, Виктория, Полина, Елизавета, Екатерина, Ксения,
    Артём, Александр, Максим, Даниил, Дмитрий, Иван, Кирилл, Никита, Михаил, Егор;
    public static Name getName(int ord){
        for (Name name : values()){
            if (ord == name.ordinal()) {
                return name;
            }
        }
        throw new AssertionError("Wrong ordinal: " + ord);
    }
}
enum  Company {
    Газнефть, ЛУКпром, РосНано, Сберик, РЖДент, X5тка, Теорема, Сургутнефтьалмазинвест, Магнитка, СетиСети;
    public static Company getCompany(int ord){
        for (Company company : values()){
            if (ord == company.ordinal()) {
                return company;
            }
        }
        throw new AssertionError("Wrong ordinal: " + ord);
    }
}
