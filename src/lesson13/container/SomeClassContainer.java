package lesson13.container;



import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

@Container(prefix = "some")
public class SomeClassContainer {

    private String name;

    private int version;

    public String getName() {
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
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        SomeClassContainer container = new SomeClassContainer();
        try (InputStream inputStream =
                     SomeClassContainer.class
                             .getClassLoader()
                             .getResourceAsStream("container.properties")) {

            Properties properties = new Properties();
            properties.load(inputStream);
            String name = properties.getProperty("name");
            int version = Integer.parseInt(properties.getProperty("version"));
            container.setName(name);
            container.setVersion(version);

        } catch (IOException e) {
            e.printStackTrace();
        }





        SomeClass someclass=new SomeClass();
        someclass.setContainer(container);
        System.out.println("2. someclass = " + someclass);




    }

    @Override
    public String toString() {
        return "SomeClassContainer{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}

@Container(prefix = "other")
class OtherConfig {
    private String name;
}