package by.ageenko.aois4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MainTest {

    @Test
    void main_shouldRunWithoutExceptions() {
        assertDoesNotThrow(() -> Main.main(new String[0]));
    }
}
