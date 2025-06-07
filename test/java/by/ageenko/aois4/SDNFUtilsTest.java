package by.ageenko.aois4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SDNFUtilsTest {

    @Test
    void generateSDNF_shouldGenerateCorrectTerms() {
        // Построим тестовую таблицу с 3 переменными + 2 столбца результата
        // Формат: A B Cin sum cout
        List<int[]> table = List.of(
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 1, 1, 0},
                new int[]{0, 1, 0, 1, 0},
                new int[]{0, 1, 1, 0, 1},
                new int[]{1, 0, 0, 1, 0},
                new int[]{1, 0, 1, 0, 1},
                new int[]{1, 1, 0, 0, 1},
                new int[]{1, 1, 1, 1, 1}
        );

        String[] vars = {"A", "B", "Cin"};

        List<String> sdnfSum = SDNFUtils.generateSDNF(table, vars, "sum");
        assertTrue(sdnfSum.stream().allMatch(s -> s.contains("A") || s.contains("B") || s.contains("Cin")));

        List<String> sdnfCout = SDNFUtils.generateSDNF(table, vars, "cout");
        assertFalse(sdnfCout.isEmpty());
    }

    @Test
    void minimize_shouldMergeTermsCorrectly() {
        List<String> terms = List.of(
                "A B Cin",
                "A !B Cin"
        );

        List<String> minimized = SDNFUtils.minimize(terms);
        assertTrue(minimized.contains("A Cin"));
        assertFalse(minimized.contains("A B Cin") && minimized.contains("A !B Cin"));
    }

    @Test
    void formatExpression_shouldFormatCorrectly() {
        List<String> terms = List.of("A B", "!A B", "A !B");
        String expr = SDNFUtils.formatExpression(terms);
        assertTrue(expr.startsWith("("));
        assertTrue(expr.contains(" ∨ "));
        assertTrue(expr.contains(")"));
    }
}
