package by.ageenko.aois4;
import java.util.*;

public class TruthTableGenerator {
    public static List<int[]> buildTable(String[] vars) {
        List<int[]> table = new ArrayList<>();
        int rows = 1 << vars.length;

        for (int i = 0; i < rows; i++) {
            int[] row = new int[vars.length + 2];
            int sum = 0;
            for (int j = 0; j < vars.length; j++) {
                row[j] = (i >> (vars.length - 1 - j)) & 1;
                sum += row[j];
            }
            row[vars.length] = (sum == 1 || sum == 3) ? 1 : 0;
            row[vars.length + 1] = (sum >= 2) ? 1 : 0;
            table.add(row);
        }
        return table;
    }

    public static void printTable(List<int[]> table, String[] vars) {
        int colWidth = 3;
        StringBuilder header = new StringBuilder();

        // Построение заголовка
        for (String var : vars) {
            header.append(String.format("%-" + colWidth + "s", var));
        }
        header.append("| ");
        header.append(String.format("%-" + colWidth + "s", "S"));
        header.append(String.format("%-" + colWidth + "s", "C(out)"));

        // Вывод заголовка
        System.out.println(header);
        System.out.println("-".repeat(header.length()));

        // Вывод строк таблицы
        for (int[] row : table) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < row.length; i++) {
                line.append(String.format("%-" + colWidth + "d", row[i]));
                if (i == vars.length - 1) {
                    line.append("| ");
                }
            }
            System.out.println(line);
        }
    }

}
