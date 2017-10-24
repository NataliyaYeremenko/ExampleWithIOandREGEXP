package ua.kharkiv.yeremenko.exIOandRegexp;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static final String REGEXP_INT = "(?<=^|\\s)([0-9]+)(?=$|\\s)";
    private static final String REGEXP_STRING = "(?iU)([a-zа-я]{3,})(\\s+)";
    private static final String REGEXP_CHAR = "(?iU)(?<=^|\\s)([a-zа-я])(?=$|\\s)";
    private static final String REGEXP_DOUBLE = "(\\d*\\.\\d+)";
    private static final String FILE_NAME = "part3.txt";
    private static final String ENCODING = "UTF8";

    public static void main(String[] args) throws IOException {
        String line = Part1.read(FILE_NAME, ENCODING);
        Scanner scanner = new Scanner(System.in);
        String check = scanner.nextLine();
        while (!("stop".equals(check))){
            String rexexp = "";
            switch (check){
                case "int":{
                    rexexp = REGEXP_INT;
                    break;
                }
                case "char":{
                    rexexp = REGEXP_CHAR;
                    break;
                }
                case "double":{
                    rexexp = REGEXP_DOUBLE;
                    break;
                }
                case "String": {
                    rexexp = REGEXP_STRING;
                    break;
                }
            }
            Pattern pattern = Pattern.compile(rexexp);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                System.out.print(matcher.group(1)+ " ");
            }
            System.out.println();
            check = scanner.nextLine();
        }
    }
}
