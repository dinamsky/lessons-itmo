package lesson12;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File statFile = new File("stat2.bin");
        LaunchStatExt launchStat = null;
        if(!statFile.exists()){
            launchStat = new LaunchStatExt();
        } else {
            try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(statFile))){
                launchStat =(LaunchStatExt) objIn.readObject();
            }  catch (IOException |ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if (launchStat.isFirstLaunch()){
            System.out.println("First launch");
        } else {
            System.out.println(launchStat);
        }
        launchStat.update();

        try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(statFile))) {
            objOut.writeObject(launchStat);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
