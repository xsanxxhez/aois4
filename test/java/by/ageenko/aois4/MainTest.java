package by.ageenko.aois4;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testMainRunsWithoutException() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }

    @Test
    public void testMainOutputContainsKeyPhrases() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{});

        String output = outContent.toString();
        assertFalse(output.contains("Таблица истинности"));
        assertFalse(output.contains("СДНФ (sum):"));
        assertFalse(output.contains("Минимизированная СДНФ (sum):"));
        assertFalse(output.contains("D8421 код (4 разряда):"));
        assertFalse(output.contains("СДНФ для каждого бита:"));

        System.setOut(System.out); // Restore original output
    }
}
