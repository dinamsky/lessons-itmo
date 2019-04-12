package patterns.dicontainer.di;

import patterns.dicontainer.Cat;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class Container {
    private ArrayList<Class> list;
    public Container(ArrayList<Class> list) {
        this.list=list;
    }
    public void start() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for(Class obj: list){
            if(obj.isAnnotationPresent(Component.class)){
                Object o =  obj.getDeclaredConstructor().newInstance();
                Field[] fields = obj.getDeclaredFields();
                for (Field field: fields){
                    if (field.isAnnotationPresent(Autofield.class)){
                        field.setAccessible(true);
                        Object c = field.getType().getDeclaredConstructor().newInstance();
                        field.set(o, c);
                        if(c.getClass().isAnnotationPresent(Config.class)){
                            Field[] field1 = c.getClass().getDeclaredFields();
                            try(InputStream stream = Container.class.getClassLoader().getResourceAsStream("C:\\Users\\Игорь\\IdeaProjects\\lessons-itmo\\resources\\config.properties")){
                                Properties pr = new Properties();
                                pr.load(stream);
                                for(Field f2: field1){
                                    f2.setAccessible(true);
                                    f2.set(c, pr.getProperty(f2.getName()));
                                }

                            }catch(IOException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }
                Method[] methods = obj.getDeclaredMethods();
                for(Method method: methods){
                    if (method.isAnnotationPresent(AutoRun.class)){
                        method.setAccessible(true);
                        method.invoke(o);
                    }
                }
            }
        }
    }
}
