package control2.cashdesk;
public class Main {
        public static void main(String[] args) {
            Restaurant restaurant = Restaurant.getInstance("Pita's");
            CashDesk cashDesk1 = new CashDesk(1, 10);
            CashDesk cashDesk2 = new CashDesk(2, 20);
            CashDesk cashDesk3 = new CashDesk(3, 15);
            CashDesk cashDesk4 = new CashDesk(4, 5);
            restaurant.addCashDesk(cashDesk1);
            restaurant.addCashDesk(cashDesk2);
            restaurant.addCashDesk(cashDesk3);
            restaurant.addCashDesk(cashDesk4);
            for (int i = 1; i < 8; i++) {
                Client client =  new Client(restaurant,  "client"+i);
                client.start();
            }
        }

}
