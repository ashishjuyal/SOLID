package ocp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class V1Parser {
    private String textToProcess;

    public void parse() throws IOException {

        BufferedReader reader = new BufferedReader(new StringReader(textToProcess));
        String line = reader.readLine();

        while(line != null) {
            switch (line.charAt(0)) {
                case '$':
                    VariableHandler variableHandler = new VariableHandler();
                    variableHandler.execute(line);
                    break;
                case '#':
                    CustomCommandHandler customCommandHandler = new CustomCommandHandler();
                    customCommandHandler.execute(line);
                    break;
                case '@':
                    DirectiveHandler directiveHandler = new DirectiveHandler();
                    directiveHandler.execute(line);
                    break;
                default:
                    ScopeHandler scopeHandler = new ScopeHandler();
                    scopeHandler.execute(line);
                    break;
            }
            line = reader.readLine();
        }
    }

}
