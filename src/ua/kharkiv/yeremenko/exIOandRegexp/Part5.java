package ua.kharkiv.yeremenko.exIOandRegexp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {
    private static final String BASE_NAME = "e:\\JAVA3\\Practice4\\src\\resources";
    private static final String FILE_EXTENSION = ".properties";
    private static final String REGEXP = "(?iU)(\\w+)(\\s+)(\\w+)";

    public static void read(String text, String local) throws IOException {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(
                new FileInputStream(BASE_NAME + "_" + local + FILE_EXTENSION), "CP1251"));
        StringBuilder lineBuf = new StringBuilder();
        String line;
        while ((line = bufReader.readLine()) != null) {
            if (line != null) lineBuf.append(line).append(System.lineSeparator());
        }
        Pattern pattern = Pattern.compile("(?m)^(\\S+)(\\s+)(\\=)(\\s+)(\\S+)$");
        Matcher matcher = pattern.matcher(lineBuf);
        while (matcher.find()) {
            if (text.equals(matcher.group(1))){
                System.out.println(matcher.group(5));
            }
        }
}

    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile(REGEXP);
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        while (!("stop".equals(inputLine))) {
            Matcher matcher = pattern.matcher(inputLine);
            while (matcher.find()) {
                read(matcher.group(1), matcher.group(3));
            }
            inputLine = scanner.nextLine();
        }
    }
}
