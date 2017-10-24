package ua.kharkiv.yeremenko.exIOandRegexp;

import java.io.IOException;
import java.util.Iterator;

public class Part4 {
    private static final String FILE_NAME = "part4.txt";
    private static final String ENCODING = "UTF8";
    //private static final String REGEXP = "(?iU)([^\\s+][^.!?]+[.!?])";

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser(FILE_NAME, ENCODING);
        Iterator<String> iterator = parser.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
