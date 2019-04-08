package lesson12.homework;

import java.io.*;
import java.util.Date;
import java.util.List;

public class Message implements Serializable {

    private String sender;
    private String messageText;


    public Message(String sender, String messageText) {
        this.sender = sender;
        this.messageText = messageText;

    }


    public Message()  { }

    public Message(String sender) {
        this.sender = sender;
    }



    public String getSender() {
        return sender;
    }



    public String getMessageText() {
        return messageText;
    }




    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", messageText='" + messageText +
                '}';
    }


}