package lesson13;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionExample {
    // Рефлексия в Java
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException {

        System.out.println(String.class);
        System.out.println(int.class);

        SomeClass someClass = new SomeClass();
        System.out.println(someClass.getClass());

        Class cls = someClass.getClass();
        System.out.println("сам класс " + cls.getName());

        cls = cls.getSuperclass();
        System.out.println("родитель " + cls.getName());

        Class<SomeClass> someCls = SomeClass.class;
        Constructor<SomeClass> someClassConstructor =
                someCls.getDeclaredConstructor(String.class, int.class);
        SomeClass someClass1 =
                someClassConstructor.newInstance("SomeClass", 3);
        SomeClass someClass2 = someClassConstructor.newInstance("ttt", 5);
        System.out.println(someClass1.toString()+"\n"+someClass2.toString()+"\n"+someClass.toString());
    }


    public static void toString(SomeClass someClass) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        Class<SomeClass> someCls = SomeClass.class;


        ///доступ к полям класса
        Field[] declared = someCls.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (Field f:declared )
        {
            if (!f.isAnnotationPresent(FieldInfo.class)){
            sb.append(f.getName());
            sb.append(" = ");
            f.setAccessible(true);
            sb.append(f.get(someClass));
            sb.append(' ');}


        }
        Method[] methods = someCls.getDeclaredMethods();
        for (Method m:methods )
        {
            sb.append(m.getName());
            sb.append(" = ");
            m.setAccessible(true);
            sb.append(m.getTypeParameters());
            sb.append(' ');


        }
        System.out.println(sb);
    }}

class SomeClass extends ParentClass{
    private String name;

    @FieldInfo
    private int version;

    public SomeClass(){

    }

    public SomeClass(String name, int version) {
        this.name = name;
        this.version = version;
    }

    @Override
    public void parentVoid() {
        super.parentVoid();
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    private String getInfo(){
       return "private void";
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }

    public  void toStr() {
    }
}

class ParentClass{
    public String parentString;
    public void parentVoid(){
        System.out.println("parent void");
    }

}