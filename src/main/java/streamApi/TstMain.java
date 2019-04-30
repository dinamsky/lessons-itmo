package streamApi;

import org.apache.lucene.search.MultiCollectorManager;

import java.util.*;
import java.util.stream.Collectors;

public class TstMain {
    public static void main(String[] args) {
        Author mike = new Author("mike",12);
        Author jake = new Author("jake",34);
        Author peter = new Author("peter",54);
        Author alice = new Author("alice",32);
        Author stefan = new Author("stefan",23);
        Author paul = new Author("paul",27);
        Author frank = new Author("frank",35);
        Author ned = new Author("ned",76);

        Article article = new Article(mike,"Java 12", Article.Cat.JAVA);
        Article article2 = new Article(peter,"Python", Article.Cat.PYTHON);
        Article article3 = new Article(alice,"Frameworks", Article.Cat.PHP);
        Article article4 = new Article(stefan,"Java from 8 to 9", Article.Cat.JAVA);
        Article article5 = new Article(paul,"Python is ...", Article.Cat.PYTHON);
        Article article6 = new Article(jake,"DataBase", Article.Cat.PHP);
        Article article7 = new Article(frank,"Flask, Pony", Article.Cat.JAVA);
        Article article8 = new Article(ned,"Java EE", Article.Cat.JAVA);
        Article article9 = new Article(mike,"What the fuck is Java", Article.Cat.JAVA);

        ArrayList<Article> articles =new ArrayList<>();
        articles.add(article);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);
        articles.add(article7);
        articles.add(article8);
        articles.add(article9);
        articles.stream().collect(Collectors.groupingBy(a->a.getAuthor().getName())).entrySet().forEach(System.out::println);
        articles.stream().map(a->a.getAuthor().getName()).distinct().sorted().forEach(System.out::println);
        articles.stream().collect(Collectors.groupingBy((a->a.getAuthor().getName()),Collectors.counting())).forEach((a,count)-> System.out.println(a+" : "+count));

        Map<Article.Cat,Map<String, List<Article>>> map = articles.stream()
                .sorted(Comparator.comparing(Article::getCat,Comparator.comparing(Enum::name))
                        .thenComparing(a->a.getAuthor().getName()))
                .collect(Collectors.groupingBy(Article::getCat,LinkedHashMap::new,Collectors.groupingBy(a->a.getAuthor().getName())));
        System.out.println(map);

        ArrayList<Author> authors= new ArrayList<>();
        authors.add(mike);
        authors.add(jake);
        authors.add(peter);
        authors.add(alice);
        authors.add(stefan);
        authors.add(paul);
        authors.add(frank);
        authors.add(ned);

        IntSummaryStatistics statistics = authors.stream()
                .collect(Collectors.summarizingInt(Author::getAge));
        System.out.println(statistics);

        ArrayList<Developer> developers = new ArrayList<>();
        Map<String, List<Developer>> posMap = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos));
        Map<String, ArrayList<Developer>> posMapArray = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,Collectors.toCollection(ArrayList::new)));
        Map<String,Long> posCount = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,Collectors.counting()));
        Map<String,Set<String>> posName = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,Collectors.mapping(Developer::getName, Collectors.toSet())));
        Map<String,Double> posAverageSalary = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,Collectors.averagingDouble(Developer::getSalary)));
        Map<String, Map<Integer,List<Developer>>> posAndAge = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,Collectors.groupingBy(Developer::getAge)));




    }
}
class Author{
    String name;
    int age;


    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return age == author.age &&
                Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Article{
    enum Cat{
        JAVA,PHP,PYTHON
    }
    Author author;
    String title;
    Cat cat;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Article(Author author, String title, Cat cat) {
        this.author = author;
        this.title = title;
        this.cat = cat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(author, article.author) &&
                Objects.equals(title, article.title) &&
                cat == article.cat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, cat);
    }

    @Override
    public String toString() {
        return "Article{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", cat=" + cat +
                '}';
    }
}
class Developer{
    private String name;
    private int age;
    private int salary;
    private String pos;

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", pos='" + pos + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return age == developer.age &&
                salary == developer.salary &&
                Objects.equals(name, developer.name) &&
                Objects.equals(pos, developer.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, pos);
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

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Developer(String name, int age, int salary, String pos) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.pos = pos;
    }
}