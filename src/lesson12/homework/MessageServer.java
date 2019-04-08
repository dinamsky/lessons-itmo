package lesson12.homework;




import java.io.IOException;

import java.net.*;
import java.util.*;


public class MessageServer {

    private int port;
    Connection connection;
    HashMap<Long,String> listUser;

    public MessageServer(int port)
    {
        this.port = port;
    }


    public String server_time(Message message)
    {
        return "сервер время = " + new Date();

    }
    public String userList(){
     String mes ="";
     for (Map.Entry entry : listUser.entrySet()) {
          mes += entry.getKey().toString()
                 + entry.getValue().toString();
     }
        return mes;}

    public String ping() {

        try {
            String ipAddress = "127.0.0.1";
            InetAddress inet = InetAddress.getByName(ipAddress);

           // System.out.println("Sending Ping Request to " + ipAddress);

            long finish = 0;
            long start = new GregorianCalendar().getTimeInMillis();

            if (inet.isReachable(5000)){
                finish = new GregorianCalendar().getTimeInMillis();
                String mes = "Ping RTT: " + (finish - start + "ms");
                return mes;
            } else {
                System.out.println(ipAddress + " NOT reachable.");
            }
        } catch ( Exception e ) {
          //  System.out.println("Exception:" + e.getMessage());
        }
        return "not reachable" ;
    }


    //--------------------------------------------
    public void start() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");

            while (true)
            {
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                Message mm=connection.readMessage();

                listUser.put(new GregorianCalendar().getTimeInMillis(),mm.getSender());
                printMessage(mm);
                String mesTextOut=someMessage(mm);
                Message mes=new Message("server", mesTextOut);
                connection.sendMessage(mes);

///------------------
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    private void printMessage(Message message){
        //   listUser.add(message.getSender());
        System.out.println("получено сообщение: " +
                message.getMessageText() + " от " + message.getSender());
    }

    private String someMessage(Message message){

        String mesText=message.getMessageText();
        String mesTextOut="";

        if ( mesText.equals("list"))  {mesTextOut= userList();}
        else if ( mesText.equals("time")) { mesTextOut=server_time(message);}
        else if ( mesText.equals("ping")) {mesTextOut= ping();}
        else  { mesTextOut="сообщение получено";}
        return  mesTextOut;


    }


    public static void main(String[] args) {
        int port = 8090;
        MessageServer messageServer = new MessageServer(port);
        try {
            messageServer.start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}