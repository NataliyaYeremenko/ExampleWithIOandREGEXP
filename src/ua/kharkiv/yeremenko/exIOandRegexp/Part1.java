package ua.kharkiv.yeremenko.exIOandRegexp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    private static final String FILE_NAME = "part1.txt";
    private static final String ENCODING = "UTF8";
    private static final String REGEXP = "(?iU)(\\w{4,})";

    public static String read(String path, String csn) throws IOException {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), csn));
        StringBuilder lineBuf = new StringBuilder();
        String line;
        while ((line = bufReader.readLine()) != null) {
            if (line != null) lineBuf.append(line).append(System.lineSeparator());
        }
        bufReader.close();
        return lineBuf.substring(0, lineBuf.length()-2);
    }

    public static void main(String[] args) throws IOException {
        String line = read(FILE_NAME, ENCODING);
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(line);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());

    }

}
