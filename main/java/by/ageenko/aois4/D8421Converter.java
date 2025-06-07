package by.ageenko.aois4;

import java.util.*;

public class D8421Converter {
    public static List<int[]> generateTable() {
        List<int[]> table = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int[] row = new int[4];
            int[] weights = {8, 4, 2, 1};
            int value = i;
            for (int j = 0; j < 4; j++) {
                if (value >= weights[j]) {
                    row[j] = 1;
                    value -= weights[j];
                } else {
                    row[j] = 0;
                }
            }
            table.add(row);
        }
        return table;
    }

    public static void printTable(List<int[]> table) {
        System.out.println("╔════╦═════╦═════╦═════╦═════╗");
        System.out.println("║ 10 ║ x1  ║ x2  ║ x3  ║ x4  ║");
        System.out.println("╠════╬═════╬═════╬═════╬═════╣");
        for (int i = 0; i < table.size(); i++) {
            int[] row = table.get(i);
            System.out.printf("║ %-2d ║  %-1d  ║  %-1d  ║  %-1d  ║  %-1d  ║%n",
                    i, row[0], row[1], row[2], row[3]);
        }
        System.out.println("╚════╩═════╩═════╩═════╩═════╝");
    }

    public static List<String> generateSDNFForBit(List<int[]> table, String[] bits, int bitIndex) {
        List<String> result = new ArrayList<>();

        for (int[] row : table) {
            if (row[bitIndex] == 1) {
                List<String> clause = new ArrayList<>();
                for (int j = 0; j < bits.length; j++) {
                    clause.add(row[j] == 1 ? bits[j] : "!" + bits[j]);
                }
                // Через пробел, не через " ∧ "
                result.add(String.join(" ", clause));
            }
        }
        return result;
    }

}
