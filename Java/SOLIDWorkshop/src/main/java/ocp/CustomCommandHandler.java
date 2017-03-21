package ocp;

public class CustomCommandHandler implements IHandler{
    @Override
    public void execute(String line) {
        System.out.println("I am custom command handler for " + line);
    }
}
