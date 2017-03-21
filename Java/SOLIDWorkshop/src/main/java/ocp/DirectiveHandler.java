package ocp;

public class DirectiveHandler implements IHandler{
    @Override
    public void execute(String line) {
        System.out.println("I am Directive handler for " + line);
    }
}
