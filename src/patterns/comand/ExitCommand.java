package patterns.comand;

public class ExitCommand extends Command {
    @Override
    String name() {
        return "exit";
    }

    @Override
    boolean execute() {
        System.out.println("exit");
        return false;
    }

    public ExitCommand(TextProcessor processor) {
        super(processor);
    }
}
