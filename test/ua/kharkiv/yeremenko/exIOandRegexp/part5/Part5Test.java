package ua.kharkiv.yeremenko.exIOandRegexp.part5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.kharkiv.yeremenko.exIOandRegexp.Part5;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Part5Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final String EOL = System.lineSeparator();

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
    public void readTest1() throws Exception {
        Part5.read("table", "ru");
        assertEquals("стол" + EOL, outContent.toString());
    }

    @Test
    public void readTest2() throws Exception {
        Part5.read("apple", "en");
        assertEquals("apple" + EOL, outContent.toString());
    }

    @Test
    public void main() throws Exception {
        System.setIn(new ByteArrayInputStream("table ru\nstop".getBytes()));
        Part5.main(new String[]{""});
        assertEquals("стол" + EOL, outContent.toString());
    }

}