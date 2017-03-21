package ocp;

public class VariableHandler implements IHandler {
    @Override
    public void execute(String line) {
        System.out.println("I am variable handler for " + line);
    }
}
