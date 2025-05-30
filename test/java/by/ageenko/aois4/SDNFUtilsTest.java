package by.ageenko.aois4;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SDNFUtilsTest {

    @Test
    public void testGenerateSDNF() {
        List<int[]> table = Arrays.asList(
                new int[]{0, 0, 1, 1},
                new int[]{1, 0, 0, 1}
        );
        String[] vars = {"A", "B", "C"};
        List<String> sdnf = SDNFUtils.generateSDNF(table, vars, "sum");

        assertEquals(2, sdnf.size());
        assertTrue(sdnf.contains("!A !B C"));
        assertTrue(sdnf.contains("A !B !C"));
    }

    @Test
    public void testMinimize() {
        List<String> input = Arrays.asList("A B", "A !B");
        List<String> minimized = SDNFUtils.minimize(input);
        assertTrue(minimized.contains("A"));
        assertEquals(1, minimized.size());
    }

    @Test
    public void testFormatExpression() {
        List<String> input = Arrays.asList("A B", "C D");
        String result = SDNFUtils.formatExpression(input);
        assertEquals("(A B) ∨ (C D)", result);
    }

    @Test
    public void testFormatExpressionEmpty() {
        String result = SDNFUtils.formatExpression(Collections.emptyList());
        assertNull(result);
    }
}

