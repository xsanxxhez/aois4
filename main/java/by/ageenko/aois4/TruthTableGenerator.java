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
        String header = String.join(" ", vars) + " | S C(out)";
        System.out.println(header);
        for (int[] row : table) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
