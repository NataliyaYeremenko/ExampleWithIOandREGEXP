package ua.kharkiv.yeremenko.exIOandRegexp;

import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser implements Iterable<String> {
    private String fileName;
    private String encoding;
    private static final String REGEXP = "(?iU)([^\\s+](\\d+\\.\\s*)*[А-ЯA-Z]((т.п.|т.д.|пр.|т.е.|т.о.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!])";
    private String line;

    public Parser(String fileName, String encoding) throws IOException {
        this.fileName = fileName;
        this.encoding = encoding;
        this.line = new Part1().read(fileName, encoding);
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIteratorImpl();
    }

    public class MyIteratorImpl implements Iterator<String>{
        private Pattern pattern = Pattern.compile(REGEXP);
        private Matcher matcher = pattern.matcher(line);

        @Override
        public boolean hasNext() {
            return matcher.find();
        }

        @Override
        public String next() {
            return matcher.group(1);
        }

        @Override
        public void remove() {
            new UnsupportedOperationException();
        }
    }

}