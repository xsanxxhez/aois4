package by.ageenko.aois4;

import java.util.*;

public class SDNFUtils {
    public static List<String> generateSDNF(List<int[]> table, String[] vars, String type) {
        List<String> result = new ArrayList<>();
        int index = type.equals("sum") ? vars.length : vars.length + 1;

        for (int[] row : table) {
            if (row[index] == 1) {
                List<String> parts = new ArrayList<>();
                for (int i = 0; i < vars.length; i++) {
                    parts.add(row[i] == 1 ? vars[i] : "!" + vars[i]);
                }
                result.add(String.join(" ", parts));
            }
        }
        return result;
    }

    public static List<String> minimize(List<String> parts) {
        Set<String> used = new HashSet<>();
        List<String> merged = new ArrayList<>();

        for (int i = 0; i < parts.size(); i++) {
            String[] a = parts.get(i).split(" ");
            for (int j = i + 1; j < parts.size(); j++) {
                String[] b = parts.get(j).split(" ");
                if (a.length != b.length) continue;

                int diffCount = 0;
                int diffIndex = -1;
                for (int k = 0; k < a.length; k++) {
                    if (!a[k].equals(b[k])) {
                        String x = a[k], y = b[k];
                        if ((x.startsWith("!") && x.substring(1).equals(y)) ||
                                (y.startsWith("!") && y.substring(1).equals(x))) {
                            diffCount++;
                            diffIndex = k;
                        } else {
                            diffCount = 2;
                            break;
                        }
                    }
                }
                if (diffCount == 1) {
                    String[] newTerm = Arrays.copyOf(a, a.length);
                    newTerm[diffIndex] = "";
                    merged.add(String.join(" ", Arrays.stream(newTerm).filter(s -> !s.isEmpty()).toArray(String[]::new)));
                    used.add(parts.get(i));
                    used.add(parts.get(j));
                }
            }
        }

        for (String term : parts) {
            if (!used.contains(term)) merged.add(term);
        }

        return new ArrayList<>(new LinkedHashSet<>(merged));
    }

    public static String formatExpression(List<String> terms) {
        if (terms == null || terms.isEmpty()) return null;
        return String.join(" ∨ ", terms.stream().map(t -> "(" + t + ")").toArray(String[]::new));
    }
}
