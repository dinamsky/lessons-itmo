package streamApi;

import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // методы получения stream объекта
//        Stream<String> stringStream = collection.stream();
//        Arrays.stream(someArr);
//        Files.lines(path_to_file);
//        "string".chars();

        Stream<Integer> integerStream = Stream.of(3, 4, 5, 2, 54, 65, 6, 4, 8, 9, 5, 34, 23, 3, 6, 75, 4, 343, 3, 234, 6, 6, 4, 3, 2, 4, -7, -32, -7);
        integerStream
                .filter(num -> num > 0)
                .map(num -> num * 100)
                .limit(6)
                .forEach(System.out::println);
        integerStream = Stream.of(3, 4, 5, 2, 54, 65, 6, 4, 8, 9, 5, 34, 23, 3, 6, 75, 4, 343, 3, 234, 6, 6, 4, 3, 2, 4, -7, -32, -7);
        integerStream.distinct().sorted().forEach(System.out::println);
        //anyMatch|noneMatch|allMatch
        integerStream = Stream.of(3, 4, 5, 2, 54, 65, 6, 4, 8, 9, 5, 34, 23, 3, 6, 75, 4, 343, 3, 234, 6, 6, 4, 3, 2, 4, -7, -32, -7, 0);
        System.out.format("anyMatch: %b \n", integerStream.anyMatch(num -> num == 0));
        integerStream = Stream.of(3, 4, 5, 2, 54, 65, 6, 4, 8, 9, 5, 34, 23, 3, 6, 75, 4, 343, 3, 234, 6, 6, 4, 3, 2, 4, -7, -32, -7);
        System.out.format("noneMatch: %b \n", integerStream.noneMatch(num -> num > 1000));
        integerStream = Stream.of(3, 4, 5, 2, 54, 65, 6, 4, 8, 9, 5, 34, 23, 3, 6, 75, 4, 343, 3, 234, 6, 6, 4, 3, 2, 4, -7, -32, -7);
        System.out.format("allMatch: %b \n", integerStream.allMatch(num -> num < 1000));
        integerStream = Stream.of(3, 4, 5, 2, 54, 65, 6, 4, 8, 9, 5, 34, 23, 3, 6, 75, 4, 343, 3, 234, 6, 6, 4, 3, 2, 4, -7, -32, -7);
        integerStream.filter(num -> num > 0).map(num -> num + "$").forEach(System.out::println);

        String[] strings = {"a", "ad", "fd4", "r43", "6y7", "tt5"};
        System.out.format("First : %s \n", Arrays.stream(strings).findFirst().orElse("collection is empty"));

        System.out.format("First : %s \n", Arrays.stream(strings).skip(strings.length - 3).findAny().orElse("empty"));
        System.out.format("ad element: %s \n", Arrays.stream(strings).filter("ad"::equals).findFirst().get());
        System.out.format("Elements contains 43: %s \n", Arrays.stream(strings).filter(s -> s.contains("43")).collect(Collectors.toList()));

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("eww", 45));
        users.add(new User("dfsdf", 4));
        users.add(new User("edww", 15));
        users.add(new User("ewfw", 45));
        users.add(new User("eww", 55));
        users.add(new User("eww", 45));
        User[] users1 = users.stream()
                .filter(user -> user.getAge()>30)
                .toArray(User[]::new);
        System.out.println(Arrays.toString(users1));
        List<User> userList = users.stream().peek(user->user.setActive(true)).collect(Collectors.toList());
        System.out.println(userList);
        users.stream().distinct().forEach(System.out::println);
        users.stream().sorted(Comparator.comparing(User::getAge));
        System.out.println(users.stream().min(Comparator.comparing(User::getAge)).get());
//collect
        strings = new String[] {"a", "ad", "fd4", "r43", "6y7", "tt5"};
        Set<String> stringList = Arrays.stream(strings).collect(Collectors.toSet());
        ArrayList<String> stringArrayList = Arrays.stream(strings).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(stringArrayList);

        Map<String,Integer> integerMap = Arrays.stream(strings).collect(Collectors.toMap(Function.identity(),String::length,((item,item1)->item)));

        System.out.println(integerMap);
        strings = new String[] {"a", "ad", "fd4", "r43", "6y7", "tt5"};
        String join = Arrays.stream(strings).collect(Collectors.joining(" : ","Begin-> "," <-end"));



    }  }
    class User{
        private String login;
        private int age;
        private boolean active;

        public User(String login, int age) {
            this.login = login;
            this.age = age;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    active == user.active &&
                    Objects.equals(login, user.login);
        }

        @Override
        public int hashCode() {
            return Objects.hash(login, age, active);
        }

        @Override
        public String toString() {
            return "User{" +
                    "login='" + login + '\'' +
                    ", age=" + age +
                    ", active=" + active +
                    '}';
        }
    }
