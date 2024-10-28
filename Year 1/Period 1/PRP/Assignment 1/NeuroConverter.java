import java.util.Scanner;

public class NeuroConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your amount?:");
        double amount = scanner.nextDouble();

        scanner.nextLine();
        converter(amount);
    }

    public static void converter(double amount) {
        // -- Write your code below

        int intAmount = (int)Math.round(amount * 100);

        int[] denominations = {100, 49, 9, 1};
        int[] coinQuantities = {0, 0, 0, 0};
        int denominationIndex = 0;

        while (intAmount != 0) {
            if (intAmount < denominations[denominationIndex]) denominationIndex++;
            else {
                intAmount -= denominations[denominationIndex];
                coinQuantities[denominationIndex]++;
            }
        }

        for (int i = 0; i < coinQuantities.length; i++) {
            System.out.println(coinQuantities[i]);
        }

        // Don't forget to print the output [check the requirements]

        // -- Write your code above
    }
}
