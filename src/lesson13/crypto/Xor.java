package lesson13.crypto;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Xor {
    public byte[] encrypt(String text, String keyWord) {
        byte[] arr = text.getBytes();
        byte[] keyarr = keyWord.getBytes();
        byte[] result = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (byte) (arr[i] ^ keyarr[i % keyarr.length]);
        }
        return result;
    }

    public String decrypt(byte[] text, String keyWord) {
        byte[] result = new byte[text.length];
        byte[] keyarr = keyWord.getBytes();
        for (int i = 0; i < text.length; i++) {
            result[i] = (byte) (text[i] ^ keyarr[i % keyarr.length]);
        }
        return new String(result);
    }
    public static void writeToFile(File file , boolean append, Charset charset) throws IOException {
        //  FileOutputStream
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, append)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append("line").append(i).append("\n");

            }
            fileOutputStream.write(sb.toString().getBytes(charset));
        }
    }
    public static void readByteArray (File file) throws IOException{
        long sum=0;
        try(FileInputStream inputStream = new FileInputStream(file);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf))>0){
                System.out.println(Arrays.toString(buf));
                outputStream.write(buf,0,len);

            }
            System.out.println(Arrays.toString(outputStream.toByteArray()));
            System.out.println(new String((outputStream.toByteArray())));
        }
    }
    public static long readByte(File file) throws IOException{
        long sum=0;
        try(FileInputStream inputStream = new FileInputStream(file)){
            System.out.println(inputStream.available());
            while (inputStream.available()>0){
                int data = inputStream.read();
                sum +=data;
                System.out.println((char)data);

            }
            return sum;
        }
    }

    }