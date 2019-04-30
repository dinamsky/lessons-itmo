package lambda;

import java.util.ArrayList;
import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        Manager alex = new Manager("alex",34,"bbdo");
        Manager tom = new Manager("tom",34,"bbdo");
        Manager cr = new Manager("craxz",34,"bbdo");

        Manager fr = new Manager("df",34,"bbdo");
        ArrayList<Manager> managers =new ArrayList<>();
        managers.add(alex);
        Comparator<Manager> byName = Comparator.comparing(Manager::getName);


    }
}
class Manager{
    private String name;
    private int age;
    private String company;

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Manager(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }
}
