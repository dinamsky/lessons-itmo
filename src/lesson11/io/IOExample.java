package lesson11.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class IOExample {
    // io | nio

    //IO API

    public static void main(String[] args) {

//        try{
//        writeToFile(new File("file.txt"),true,Charset.forName("UTF-8"));}
//        catch (IOException e){
//            e.printStackTrace();
//        }
        File file = new File("file.txt");

        try{
            readByteArray(file);}
        catch (IOException e){
            e.printStackTrace();
        }
        File[] files = new File[2];
        files[0] = new File("file.txt");
        files[1] = new File("lessons.iml");
        try{
            readSevFiles(files,Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //IO API
        //работают побайтно
        //InputStream
        //OutputStream

        // работают по char
        //Reader
        //Writer
    }
    public static void writeToFile(File file , boolean append, Charset charset) throws IOException {
      //  FileOutputStream
        try(FileOutputStream fileOutputStream = new FileOutputStream(file , append)){
            StringBuilder sb = new StringBuilder();
            for (int i =0; i<6; i++){
                sb.append("line").append(i).append("\n");

            }
            fileOutputStream.write(sb.toString().getBytes(charset));
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
    public void writeWithBuffer(File file) throws IOException{
        try(FileOutputStream outputStream = new FileOutputStream(file);
        BufferedOutputStream buffer = new BufferedOutputStream(outputStream)){
            StringBuilder sb = new StringBuilder();
            for (int i =0; i<6; i++){
                sb.append("line").append(i).append("\n");

            }
            byte[]bufferArr = sb.toString().getBytes();
            buffer.write(bufferArr,0,bufferArr.length);

        }
    }
    public static void readSevFiles(File[] files,Charset charset) throws IOException{
        try(FileInputStream inputStream1 = new FileInputStream(files[0]);
        FileInputStream inputStream2 = new FileInputStream(files[1]);
        ByteArrayOutputStream bout = new ByteArrayOutputStream()){
            SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1,inputStream2);
            byte[] buf = new byte[1024];
            int len;
            while ((len = sequenceInputStream.read(buf))>0){
                System.out.println(Arrays.toString(buf));
                bout.write(buf,0,len);

            }
            System.out.println(Arrays.toString(bout.toByteArray()));
            System.out.println(new String((bout.toByteArray())));
        }

    }


}
