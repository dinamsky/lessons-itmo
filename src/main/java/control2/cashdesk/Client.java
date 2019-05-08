package control2.cashdesk;

import java.util.concurrent.locks.ReentrantLock;


public class Client extends Thread  {
    private static ReentrantLock lock = new ReentrantLock();
    private Restaurant restaurant;
    private CashDesk cashDesk;
    private String name;
    private int itemsInOrder;
    private boolean isBeingServed;
    private boolean isServed;

    public Client(Restaurant restaurant, int itemsInOrder, String name) {
        this.restaurant = restaurant;
        this.itemsInOrder = itemsInOrder;
        this.name = name;
    }

    public String getClientName() {
        return name;
    }

    public int getItemsInOrder() {
        return itemsInOrder;
    }

    public boolean StartServe(CashDesk cashDesk) throws InvalidOperationException{
        lock.lock();
        try
        {
            if (cashDesk != this.cashDesk)
                return false;
            if (isServed)
                throw new InvalidOperationException("sdffdsg");
            isBeingServed = true;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public void FinishServe() throws InvalidOperationException{
        lock.lock();
        try {
            if (!isBeingServed)

                throw new InvalidOperationException("fgdsghnhdf");
            isBeingServed = false;
            isServed = true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        System.out.println("Клиент " + name + " пришел в ресторан " + restaurant.getName());

        if (!tryEnterQueue(chooseCashDesk())) {
            System.out.println("Клиент " + getClientName() +
                    " не может встать в кассу#"+ cashDesk.getNumber());
            return;
        }
        System.out.println("Клиент " + getClientName() +
                " встал в кассу#"+ cashDesk.getNumber());

        while (true) {
            lock.lock();
            boolean finishLoop = isBeingServed;
            lock.unlock();
            if (finishLoop)
                break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switchToBetterCashDeskIfPossible();
            if (cashDesk == null)
                break;
        }


        while (true) {
            lock.lock();
            boolean finishLoop = isServed;
            lock.unlock();
            if (finishLoop)
                break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Клиент " + getClientName() + " кушает)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Клиент " + getClientName() + " покинул ресторан");
    }

    private CashDesk chooseCashDesk() {
        CashDesk result = restaurant.getCashDesks().get(0);
        for (CashDesk cashDesk : restaurant.getCashDesks()) {
            if(cashDesk.getClients().size() < result.getClients().size()) {
                result = cashDesk;
            }
        }
        return result;
    }

    private boolean tryEnterQueue(CashDesk cashDesk) {

        try {
            cashDesk.addClient(this);
            this.cashDesk = cashDesk;
            return true;
        } catch(UnsupportedOperationException e) {
            System.out.println("Клиент " + getClientName() +
                    " не может встатьв кассу#" + cashDesk.getNumber() +
                    " и не знает куда ему идти");
            return false;
        }
    }


    private void switchToBetterCashDeskIfPossible() {
        lock.lock();
        boolean skipSwitch = isBeingServed;
        lock.unlock();
        if (skipSwitch)
            return;
        CashDesk result = chooseCashDesk();
        if (result == cashDesk)
            return;
        cashDesk.removeClient(this);

        if (tryEnterQueue(cashDesk)) {
            System.out.println("Клиент " + getClientName() + " перешел  на кассу#" + cashDesk.getNumber());
        }
    }
}