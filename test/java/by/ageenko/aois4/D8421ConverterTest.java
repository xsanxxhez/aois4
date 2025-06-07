package by.ageenko.aois4;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class D8421ConverterTest {

    @Test
    void generateTable_shouldGenerateCorrectTable() {
        List<int[]> table = D8421Converter.generateTable();
        assertEquals(10, table.size());

        // Проверим первые 3 строки для корректности кодирования
        assertArrayEquals(new int[]{0, 0, 0, 0}, table.get(0));
        assertArrayEquals(new int[]{0, 0, 0, 1}, table.get(1));
        assertArrayEquals(new int[]{0, 0, 1, 0}, table.get(2));

        // Проверим, что все строки имеют длину 4
        for (int[] row : table) {
            assertEquals(4, row.length);
            for (int bit : row) {
                assertTrue(bit == 0 || bit == 1);
            }
        }
    }

    @Test
    void generateSDNFForBit_shouldReturnCorrectSDNF() {
        List<int[]> table = D8421Converter.generateTable();
        String[] bits = {"x1", "x2", "x3", "x4"};

        // Проверим, что для бита 0 (старший) термы корректны
        List<String> sdnf = D8421Converter.generateSDNFForBit(table, bits, 0);
        assertFalse(sdnf.isEmpty());
        for (String term : sdnf) {
            assertTrue(term.contains("x1") || term.contains("!x1"));
        }
    }
}
