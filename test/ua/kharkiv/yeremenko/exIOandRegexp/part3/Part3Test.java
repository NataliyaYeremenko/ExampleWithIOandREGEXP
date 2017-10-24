package ua.kharkiv.yeremenko.exIOandRegexp.part3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.kharkiv.yeremenko.exIOandRegexp.Part3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Part3Test {
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
    public void mainTest1() throws Exception {
        System.setIn(new ByteArrayInputStream("double\nstop".getBytes()));
        Part3.main(new String[]{""});
        assertEquals("43.43 .98 " + EOL, outContent.toString());
    }

    @Test
    public void mainTest2() throws Exception {
        System.setIn(new ByteArrayInputStream("int\nstop".getBytes()));
        Part3.main(new String[]{""});
        assertEquals("432 456 89 " + EOL, outContent.toString());
    }

    @Test
    public void mainTest3() throws Exception {
        System.setIn(new ByteArrayInputStream("char\nstop".getBytes()));
        Part3.main(new String[]{""});
        assertEquals("a и л " + EOL, outContent.toString());
    }

    @Test
    public void mainTest4() throws Exception {
        System.setIn(new ByteArrayInputStream("String\nstop".getBytes()));
        Part3.main(new String[]{""});
        assertEquals("bcd фвыа " + EOL, outContent.toString());
    }
}