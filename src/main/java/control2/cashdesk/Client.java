package control2.cashdesk;


public class Client extends Thread {
    private Restaurant restaurant;
    private CashDesk cashDesk;
    private String name;


    public Client(Restaurant restaurant, String name) {
        this.restaurant = restaurant;
        this.name = name;
    }

    public String getClientName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Клиент " + name + " пришел в ресторан " + restaurant.getName());
        this.cashDesk = chooseCashDesk();
        System.out.println("Клиент " + getClientName() + " встал на кассу#"+ cashDesk.getNumber()+" в очереди " + cashDesk.getClients().size() +" человек");
        cashDesk.addClient(this);
        while (true) {
            if (cashDesk.getLock().tryLock())
//            if(cashDesk.current==null)
//                cashDesk.nextClient();
//            if (cashDesk.current==this)
            {
                try {
                    cashDesk.serveClient(this);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    cashDesk.getLock().unlock();
            //        cashDesk.nextClient();
                    break;
                }
            } else {
                if (changeCashDesk()) {
                    cashDesk.removeClient(this);
                }
            }
        }
        cashDesk.removeClient(this);
        System.out.println("Клиент " + getClientName() + " покинул ресторан");
    }

    private CashDesk chooseCashDesk(){
        CashDesk result = restaurant.getCashDesks().get(0);
        for (CashDesk cashDesk : restaurant.getCashDesks()) {
            if(cashDesk.getClients().size() < result.getClients().size()) {
                result = cashDesk;
            }
        }
        return result;
    }

    private boolean changeCashDesk() {
        CashDesk result = chooseCashDesk();
        if(result.getClients().size() + 1 < cashDesk.getClients().size()) {
            cashDesk = result;
            cashDesk.addClient(this);
            System.out.println("Клиент " + getClientName() + " перешел на кассу#" + cashDesk.getNumber()+" встал "+cashDesk.getClients().size());
            return true;
        }
        return false;
    }
}