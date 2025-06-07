package by.ageenko.aois4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TruthTableGeneratorTest {

    @Test
    void buildTable_shouldCreateCorrectTable() {
        String[] vars = {"A", "B", "Cin"};
        List<int[]> table = TruthTableGenerator.buildTable(vars);
        int expectedRows = 1 << vars.length;
        assertEquals(expectedRows, table.size());

        for (int[] row : table) {
            assertEquals(vars.length + 2, row.length);
            for (int bit : row) {
                assertTrue(bit == 0 || bit == 1);
            }
        }
    }

    @Test
    void printTable_shouldNotThrow() {
        String[] vars = {"A", "B", "Cin"};
        List<int[]> table = TruthTableGenerator.buildTable(vars);

        // Проверяем, что вызов печати таблицы не вызывает исключений
        assertDoesNotThrow(() -> TruthTableGenerator.printTable(table, vars));
    }
}
