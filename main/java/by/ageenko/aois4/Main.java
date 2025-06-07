package by.ageenko.aois4;

public class Main {
    public static void main(String[] args) {
        String[] inputVars = {"A", "B", "Cin"};
        var truthTable = TruthTableGenerator.buildTable(inputVars);

        System.out.println("╔════════════════════╗");
        System.out.println("║ ТАБЛИЦА ИСТИННОСТИ ║");
        System.out.println("╚════════════════════╝");
        TruthTableGenerator.printTable(truthTable, inputVars);

        System.out.println("\n╔════════════════════╗");
        System.out.println("║   СДНФ ДЛЯ СУММЫ   ║");
        System.out.println("╚════════════════════╝");
        var sdnfSum = SDNFUtils.generateSDNF(truthTable, inputVars, "sum");
        System.out.println("Полная СДНФ:");
        System.out.println(SDNFUtils.formatExpression(sdnfSum));

        var minimizedSum = SDNFUtils.minimize(sdnfSum);
        System.out.println("\nМинимизированная СДНФ:");
        System.out.println(SDNFUtils.formatExpression(minimizedSum));

        System.out.println("\n╔════════════════════╗");
        System.out.println("║ СДНФ ДЛЯ ПЕРЕНОСА  ║");
        System.out.println("╚════════════════════╝");
        var sdnfCarry = SDNFUtils.generateSDNF(truthTable, inputVars, "cout");
        System.out.println("Полная СДНФ:");
        System.out.println(SDNFUtils.formatExpression(sdnfCarry));

        var minimizedCarry = SDNFUtils.minimize(sdnfCarry);
        System.out.println("\nМинимизированная СДНФ:");
        System.out.println(SDNFUtils.formatExpression(minimizedCarry));

        System.out.println("\n╔════════════════════╗");
        System.out.println("║    D8421 ТАБЛИЦА   ║");
        System.out.println("╚════════════════════╝");
        String[] bits = {"x1", "x2", "x3", "x4"};
        var dTable = D8421Converter.generateTable();
        D8421Converter.printTable(dTable);

        System.out.println("\n╔════════════════════╗");
        System.out.println("║СДНФ ПО БИТАМ D8421 ║");
        System.out.println("╚════════════════════╝");

        for (int i = 0; i < 4; i++) {
            var expr = D8421Converter.generateSDNFForBit(dTable, bits, i);
            System.out.printf("\n┌───────────────[ Бит x%d ]───────────────┐%n", i + 1);
            System.out.println("│ СДНФ:");
            System.out.println("│ " + SDNFUtils.formatExpression(expr).replaceAll(" ∨ ", "\n│ ∨ "));
            System.out.println("│");
            System.out.println("│ Минимизация:");
            System.out.println("│ " + SDNFUtils.formatExpression(SDNFUtils.minimize(expr)).replaceAll(" ∨ ", "\n│ ∨ "));
            System.out.println("└──────────────────────────────────────────┘");
        }

    }
}
