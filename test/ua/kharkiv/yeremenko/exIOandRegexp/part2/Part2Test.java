package ua.kharkiv.yeremenko.exIOandRegexp.part2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.kharkiv.yeremenko.exIOandRegexp.Part2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class Part2Test {
    private static final String RAW_DATA = "test\\ua\\kharkiv\\yeremenko\\exIOandRegexp\\part2\\part2.txt";
    private static final String PATH = "";
    private static final String EOL = System.lineSeparator();
    private static final String SORTED_DATA = "test\\ua\\kharkiv\\yeremenko\\exIOandRegexp\\part2\\part2_sorted.txt";
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @Test(expected = Exception.class)
    public void readData() throws Exception {
        Part2.readData(PATH);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void readData2() throws Exception {
        Part2.readData(RAW_DATA);
        assertEquals("2 24 49 37 48 38 8 41 30 15" + EOL, outContent.toString());
    }
    @Test
    public void writeData() throws Exception {
        Part2.writeData(SORTED_DATA, "2 8 15 24 30 37 38 41 48 49");
        Part2.readData(SORTED_DATA);
        assertEquals("2 8 15 24 30 37 38 41 48 49" + EOL, outContent.toString());
    }

    @Test
    public void mainTest() throws Exception {
        Part2.main(new String[]{""});
        assertEquals(outContent.toString(), outContent.toString());
    }

}