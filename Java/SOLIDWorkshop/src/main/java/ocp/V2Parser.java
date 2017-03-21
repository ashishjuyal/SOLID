package ocp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

public class V2Parser {
    private String textToProcess;
    private Map<Character, IHandler> _handlers;

     public V2Parser(Map<Character, IHandler> handlers) {
        this._handlers = handlers;
     }

    public void parse() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(textToProcess));
        String line = reader.readLine();

        while(line != null) {
            IHandler handler = _handlers.get(line.charAt(0));
            handler.execute(line);
            line = reader.readLine();
        }
    }
}
