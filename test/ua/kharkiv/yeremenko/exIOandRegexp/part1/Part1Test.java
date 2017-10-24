package ua.kharkiv.yeremenko.exIOandRegexp.part1;

import org.junit.Assert;
import org.junit.Test;
import ua.kharkiv.yeremenko.exIOandRegexp.Part1;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class Part1Test {
    private static final String EOL = System.lineSeparator();
    private static final String PATH1 = "test\\ua\\kharkiv\\yeremenko\\exIOandRegexp\\part1\\part1_1.txt";
    private static final String PATH2 = "test\\ua\\kharkiv\\yeremenko\\exIOandRegexp\\part1\\part1_2.txt";
    private static final String PATH3 = "test\\ua\\kharkiv\\yeremenko\\exIOandRegexp\\part1\\part1_3.txt";
    private static final String PATH4 = "test\\ua\\kharkiv\\yeremenko\\exIOandRegexp\\part1\\part1_4.txt";
    private static final String REGEXP = "(?iU)(\\w{4,})";
    @Test
    public void testRead1() throws Exception {
        String actually = Part1.read(PATH1, "UTF8");
        String expected = "when I was younger" + EOL +
                "So much younger" + EOL +
                "than today";
        Assert.assertEquals(expected, actually);
    }
    @Test
    public void testRead2() throws Exception {
        String actually = Part1.read(PATH2, "UTF8");
        String expected = "Du hast mich gefragt" + EOL +
                "Du hast mich gefragt und ich hab nichts gesagt" + EOL +
                "Willst du bis der Tod uns scheidet" + EOL +
                "Treue sein für alle Tage";
        Assert.assertEquals(expected, actually);
    }

    @Test
    public void testRead3() throws Exception {
        try{
            Part1.read("part1_5.txt", "UTF8");
        }catch (Exception ex){
            if (ex.getClass() != FileNotFoundException.class){
                fail("FileNotFoundException checked");
            }
        }
    }

    @Test(expected = Exception.class)
    public void testRead4() throws Exception {
        Part1.read(PATH3, "CP1251");
    }

    @Test
    public void testRead5() throws Exception {
        String actually = Part1.read(PATH4, "UTF8");
        String expected = "k";
        Assert.assertEquals(expected, actually);
    }

    @Test
    public void mainTest1() throws Exception {
        String line = Part1.read(PATH1, "UTF8");
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(line);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        String actually = sb.toString();
        String expected = "WHEN I was YOUNGER" + EOL +
                "So MUCH YOUNGER" + EOL +
                "THAN TODAY";
        Assert.assertEquals(expected, actually);
    }

    @Test
    public void testConstr() throws Exception {
        new Part1();
    }
}