package lesson13;

import jdk.jfr.Enabled;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
@Enabled
public class ReflectionExample {
    // Рефлексия в Java
    public static void toString(SomeClass someClass) throws NoSuchFieldException, IllegalAccessException {

        Class<SomeClass> someCls = SomeClass.class;
        ///доступ к полям класса
        Field[] declared = someCls.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (Field f:declared )
        {
            sb.append(f.getName());
            sb.append(" = ");
            f.setAccessible(true);
            sb.append(f.get(someClass));
            sb.append(' ');


        }
        System.out.println("SomeClass " + sb);
    }}

class SomeClass extends ParentClass{
    private String name;
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
    @FieldInfo
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

}}