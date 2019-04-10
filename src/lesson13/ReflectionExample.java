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
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        System.out.println(String.class);
        SomeClass someClass = new SomeClass();
        //System.out.println(someClass.getClass());

        //    System.out.println(SomeClass.toStr());}
        public void toStr (Object obj){
            //Доступ к компонентам класса
            Class cls = obj.getClass();
            Class<?> someCls = obj.getClass();

            //доступ к полям класса
            Field[] fields = someCls.getFields();
            System.out.println(Arrays.toString(fields));

            Field[] declaredField = someCls.getDeclaredFields();
            System.out.println(Arrays.toString(declaredField));

            //доступ к методам класса
            Method[] methods = someCls.getMethods();
            System.out.println(Arrays.toString(methods));
            Method[] declaredMethods = someCls.getDeclaredMethods();
            System.out.println(declaredMethods);

            //оступ к конструкторам
            Constructor<?>[] declaredConstructors = someCls.getDeclaredConstructors();
            System.out.println(Arrays.toString(declaredConstructors));
            // доступ к конкретному полю, методу, конструктору
            //  Field field = someCls.getDeclaredField("version");
            //  System.out.println(field.getType());
            //  field.setAccessible(true);
            //   field.set(someClass, 1);
            System.out.println();
            //доступ к приватному методу
//           Method method = someCls.getDeclaredMethod();
//           method.setAccessible(true);
//           String data = (String) method.invoke(obj);
//            System.out.println("data:" + data);

            //конструктор
            Constructor<SomeClass> someClassConstructor = someCls.getDeclaredConstructor(String.class, int.class);
            SomeClass someClass1 = someClassConstructor.newInstance("someClass", 1);
            System.out.println(someClass1);


        }


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

}