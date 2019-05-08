package control2.cashdesk;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class CashDesk extends Thread {

private ReentrantLock lock = new ReentrantLock();
private LinkedList<Client> clients;
private int number;
private int timeOfService;
private boolean isShutdownRequested;

public CashDesk(int number, int timeOfService) {
        clients = new LinkedList<>();
        this.number = number;
        this.timeOfService = timeOfService;
        }

@Override
public void run() {

        while (true) {
        Client client = null;
        try {
        lock.lock();
        if (isShutdownRequested)
        break;
        if (clients.size() > 0)
        client = clients.removeFirst();
        } finally {
        lock.unlock();
        }
        if (client == null) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            continue;
        }
            try {
                serveClient(client);
            } catch (InterruptedException | InvalidOperationException e) {
                e.printStackTrace();
            }
        }
        }


private void serveClient(Client client) throws InterruptedException, InvalidOperationException {
        System.out.println("Клиент " + client.getClientName() +
        " обслуживается на кассе#" + getNumber());

        if (!client.StartServe(this))

        return;
        Thread.sleep(timeOfService );
        client.FinishServe();
        System.out.println("Клиент " + client.getClientName() + " обслужен");
        }


public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
        }


public void addClient(Client client) {
        if (isShutdownRequested){
            System.out.println("очередь больше не принимает");
        return;}
        clients.add(client);
        }


public void removeClient(Client client) {
        clients.remove(client);
        }


public int getNumber() {
        return number;
        }


        }