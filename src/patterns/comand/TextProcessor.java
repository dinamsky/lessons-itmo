//package patterns.comand;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class TextProcessor  {
//    public static void main(String[] args) {
//        TextProcessor processor = new TextProcessor();
//        processor.start();
//    }
//
//    private CommandHistory history = new CommandHistory();
//
//    public void executeCommand(Command command){
//        command.execute();
//        history.add(command);
//    }
//public void start(){
//    Scanner scanner = new Scanner(System.in);
//    while(true){
//        switch(scanner.nextLine()){
//            case "process": executeCommand(new ProcessCommand(this));
//            break;
//            case "exit":executeCommand(new ExitCommand(this));
//            break;
//        }
//    }
//
//}
//
//
//}
//class CommandHistory{
//    private Stack<Command> history = new ArrayList<>();
//    public void add(Command command){
//        history.push(command);
//    }
//    public Command delete(){
//        return history.pop();
//    }
//    public boolean isEmpty(){
//        return history.isEmpty();
//    }
//}
