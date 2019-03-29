package lesson9.homework;

public class Work {
    public static void main(String[] args) {

    }
}
enum PeopleOfBoilerRoom{
    CARLCOX("cARL",12,"TECHNO"),
    ARTDEPARTMENT("FRITZ",23,"HOUSE");
    private String name;
    private int age;
    private String style;

    PeopleOfBoilerRoom(String name, int age, String style) {
        this.name = name;
        this.age = age;
        this.style = style;
    }
}