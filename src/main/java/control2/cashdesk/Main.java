package control2.cashdesk;

import java.util.Random;

public class Main {


        public static void main(String[] args) {
            Restaurant restaurant = Restaurant.getInstance("Mcdonalds");
            CashDesk cashDesk1 = new CashDesk(1, 10);
            CashDesk cashDesk2 = new CashDesk(2, 20);

            restaurant.addCashDesk(cashDesk1);
            restaurant.addCashDesk(cashDesk2);


            new Client(restaurant, 15, "client1").start();
            Random random = new Random();
            for (int i = 1; i < 8; i++) {

                int randNumbOfItems = random.nextInt(10) + 1;
                Client client =  new Client(restaurant, randNumbOfItems, "client"+i);
                client.start();
            }
        }

}
