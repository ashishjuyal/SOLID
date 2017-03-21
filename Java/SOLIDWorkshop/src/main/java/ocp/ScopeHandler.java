package ocp;

public class ScopeHandler implements IHandler{
    @Override
    public void execute(String line) {
        System.out.println("I am scope handler for " + line);
    }
}
