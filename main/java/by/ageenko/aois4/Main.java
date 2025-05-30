package by.ageenko.aois4;

public class Main {
    public static void main(String[] args) {
        String[] inputVars = {"A", "B", "Cin"};

        var truthTable = TruthTableGenerator.buildTable(inputVars);
        TruthTableGenerator.printTable(truthTable, inputVars);

        var sdnfSum = SDNFUtils.generateSDNF(truthTable, inputVars, "sum");
        System.out.println("\nСДНФ для суммы:");
        System.out.println(SDNFUtils.formatExpression(sdnfSum));

        var minimizedSum = SDNFUtils.minimize(sdnfSum);
        System.out.println("Минимизация СДНФ суммы:");
        System.out.println(SDNFUtils.formatExpression(minimizedSum));

        var sdnfCarry = SDNFUtils.generateSDNF(truthTable, inputVars, "cout");
        System.out.println("\nСДНФ для переноса:");
        System.out.println(SDNFUtils.formatExpression(sdnfCarry));

        var minimizedCarry = SDNFUtils.minimize(sdnfCarry);
        System.out.println("Минимизация СДНФ переноса:");
        System.out.println(SDNFUtils.formatExpression(minimizedCarry));

        System.out.println("\nD8421 таблица:");
        String[] bits = {"x1", "x2", "x3", "x4"};
        var dTable = D8421Converter.generateTable();
        D8421Converter.printTable(dTable);

        for (int i = 0; i < 4; i++) {
            var expr = D8421Converter.generateSDNFForBit(dTable, bits, i);
            System.out.printf("СДНФ для бита %d: %s\n", i, SDNFUtils.formatExpression(expr));
            System.out.println("Минимизация: " + SDNFUtils.formatExpression(SDNFUtils.minimize(expr)));
        }
    }
}