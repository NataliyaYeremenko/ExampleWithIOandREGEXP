package ua.kharkiv.yeremenko.exIOandRegexp.part4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.kharkiv.yeremenko.exIOandRegexp.Part4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class Part4Test {
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
    public void mainTest() throws Exception {
        Part4.main(new String[]{""});
        assertEquals("Класс должен разбирать текстовый файл и возвращать предложения из файла." + EOL +
                "Под предложением понимать последовательность, которая начинается с большой буквы и заканчивается точкой." + EOL +
                "Исходный файл брать небольшим по размеру." + EOL +
                "Достаточно нескольких строк и нескольких предложений." + EOL, outContent.toString());
    }
}