package lesson6.classwork.nested;

public class Food {
    private final int portion;// обязательное свойство
    // дополнительные свойства
    private final int fat;
    private final int calories;

    String field;


    static class Builder {
        private final int portion;
        private int fat = 0;
        private int calories = 0;

        public Builder(int portion){
            this.portion = portion;
        }
        public Builder calories(int calories){
            this.calories = calories;
            return this;
        }
        public Builder fat(int fat){
            this.fat = fat;
            return this;
        }
        public Food build(){
            return new Food(this);
        }

    }


    private Food(Builder builder){
        portion = builder.portion;
        fat = builder.fat;
        calories = builder.calories;

    }

    @Override
    public String toString() {
        return "Food{" +
                "portion=" + portion +
                ", fat=" + fat +
                ", calories=" + calories +
                '}';
    }
}


