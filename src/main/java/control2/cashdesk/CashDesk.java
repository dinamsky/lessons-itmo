package control2.cashdesk;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class CashDesk {

    private ReentrantLock lock = new ReentrantLock();
    private LinkedList<Client> clients;
    private int number;
    private int timeOfService;

    public CashDesk(int number, int timeOfService) {
        clients = new LinkedList<>();
        this.number = number;
        this.timeOfService = timeOfService;

    }

    public void serveClient(Client client) throws InterruptedException {
        System.out.println("Клиент "+client.getClientName() + " обслуживается на кассе#"+getNumber());

            client.sleep(timeOfService );

        System.out.println("Клиент "+client.getClientName() + " обслужен");
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public int getNumber() {
        return number;
    }

    public ReentrantLock getLock() {
        return lock;
    }
}