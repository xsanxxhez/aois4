package by.ageenko.aois4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class D8421ConverterTest {

    @Test
    public void testGenerateTableSize() {
        List<int[]> table = D8421Converter.generateTable();
        assertEquals(10, table.size());
    }

    @Test
    public void testGenerateTableContent() {
        List<int[]> table = D8421Converter.generateTable();
        int[] weights = {8, 4, 2, 1};
        for (int i = 0; i < 10; i++) {
            int[] row = table.get(i);
            int value = 0;
            for (int j = 0; j < 4; j++) {
                value += row[j] * weights[j];
            }
            assertEquals(i, value);
        }
    }

    @Test
    public void testGenerateSDNFForBit() {
        List<int[]> table = D8421Converter.generateTable();
        String[] bits = {"x1", "x2", "x3", "x4"};
        List<String> sdnf = D8421Converter.generateSDNFForBit(table, bits, 0);
        assertNotNull(sdnf);
        assertTrue(sdnf.size() > 0);
    }
}
