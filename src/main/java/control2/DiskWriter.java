package control2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class DiskWriter {
    public static void main(String[] args) throws Exception {
        new DiskWriter().run(args);
    }

    public void run(String... args) throws Exception {
        Path path = Paths.get("file.txt");
        if (!Files.exists(path)) {
            Files.createFile(path);
        } else {
            Files.delete(path);
            Files.createFile(path);
        }
        BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        Thread[] threads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            threads[i] = new Thread(new DataWriter(writer, createDataItems(i)));
        }
        Arrays.asList(threads).forEach(Thread::start);
        Arrays.asList(threads).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        });
        writer.close();
    }
    private List<Data> createDataItems(int groupNumber) {
        List<Data> items = new ArrayList<>();
        for (int i =0; i<1000; i++) {
            Data item = new Data();
            item.group = groupNumber;
            item.itemNumber = i;
            item.firstValue = "{group" + groupNumber + "item" + i + "}";
            item.secondValue = "{group" + groupNumber + "item" + i + "}";
            for (int j =0; j< 10; j ++) {
                item.addInnerProperty("innerProp"+j , "{group" + groupNumber + "item" + i + "}");
            }
            for (int j=0; j<20; j++) {
                item.addListValue("{group" + groupNumber + "item" + i + "}");
            }
            items.add(item);
        }
        return items;
    }
    private class DataWriter implements Runnable {
        private ArrayList<String> data;
        private PrintWriter writer;
        public DataWriter(BufferedWriter writer, List<Data> items) {
            this.writer = new PrintWriter(writer);
            this.data = new ArrayList<String>();
            ObjectMapper mapper = new ObjectMapper();
            for (Data i : items) {
                try {
                    String stringValue = mapper.writeValueAsString(i);
                    data.add(stringValue);
                } catch (JsonProcessingException e) {

                    e.printStackTrace();
                }
            }
        }
@Override
        public void run() {
            System.out.println("Starting batch");
            data.forEach(t -> {
                writer.println(t);
                writer.flush();
            });
            System.out.println("finishing batch");
        }
    }
    public static class Data {
        public int itemNumber;
        public int group;
@JsonProperty
        private String firstValue;
@JsonProperty
        private String secondValue;
@JsonProperty
        private Map<String, String> innerObject = new HashMap<>();
@JsonProperty
        private List<String> listValues = new ArrayList<>();
        public void addInnerProperty(String key, String value){
            this.innerObject.put(key, value);
        }
        public void addListValue(String value) {
            this.listValues.add(value);
        }
    }
}