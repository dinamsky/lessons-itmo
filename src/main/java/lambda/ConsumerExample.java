package lambda;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        ButtonFactory<Button> factory = Button::new;
        Button button = factory.set("gray","Cancel");
        System.out.println(button);
        Consumer<Button> makeBtn = (button1->{
            button1.setColor("white");
            button1.setValue("reset");

        });
        makeBtn.accept(button);
        System.out.println(button);

    }
}
class Button{
    String color;
    String value;

    @Override
    public String toString() {
        return "Button{" +
                "color='" + color + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public Button(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

interface ButtonFactory<T extends Button>{
    T set(String value, String color);

}