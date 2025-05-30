package by.ageenko.aois4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TruthTableGeneratorTest {

    @Test
    public void testBuildTableSize() {
        String[] vars = {"A", "B", "Cin"};
        List<int[]> table = TruthTableGenerator.buildTable(vars);
        assertEquals(8, table.size());
    }

    @Test
    public void testBuildTableContent() {
        String[] vars = {"A", "B", "Cin"};
        List<int[]> table = TruthTableGenerator.buildTable(vars);
        for (int[] row : table) {
            int inputSum = row[0] + row[1] + row[2];
            int sumExpected = (inputSum == 1 || inputSum == 3) ? 1 : 0;
            int coutExpected = (inputSum >= 2) ? 1 : 0;
            assertEquals(sumExpected, row[3]);
            assertEquals(coutExpected, row[4]);
        }
    }
}
