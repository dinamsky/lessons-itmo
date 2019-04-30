package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User("wet",23,"3uisia");
        User user2 = new User("wet",23,"3uisia");
        User user3 = new User("wet",23,"3uisia");
        User user4 = new User("wet",23,"3uisia");
        User user5 = new User("wet",23,"3uisia");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        Listeners listeners = new Listeners();
        List<User> russianUsers = listeners.getFilterUsers(user->"Russia".equals(user.getCountry()));




    }
}
class Listeners{
    private List<User> userList;
    public List<User> getFilterUsers(Predicate<User> filter){
        List<User> list = new ArrayList<>();
        for (User user: userList){
            if (filter.test(user)){
                list.add(user);
            }
        }
        return  list;
    }
}
class User{
    String login;
    int age;
    String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(login, user.login) &&
                Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, age, country);
    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public User(String login, int age, String country) {
        this.login = login;
        this.age = age;
        this.country = country;
    }
}