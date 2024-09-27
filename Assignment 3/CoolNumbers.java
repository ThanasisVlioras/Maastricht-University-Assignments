import java.util.*;

public class CoolNumbers {

    public static void main(String[] args) {
        // This is just to test your method

        System.out.println("1\n 2\n  3\n   4\n  5\n    6\n     7\n       8\n        9");
        // System.out.println("1\n 2\n  3\n   4\n    5\n     6\n      7\n       8\n        9");

        // for (int i = 0; i < 10; i++) {
        //     for (int j = 10; j > i; j--) {
        //         System.out.print(" ");
        //     }

        //     System.out.println(i);
        // }
    }

    public static boolean isCool(int x, int n) {
        // your code here

        String digits = Integer.toString(x);

        for (char charDigit : digits.toCharArray()) {
            int digit = charDigit - '0';

            if (digit == 0) return false;
            if (n % digit != 0) return false;
        }

        return true;
    }

    public static int countCools(int n, int a, int b) {
        // your code here

        int count = 0;
        for (int i = a; i <= b; i++) if (isCool(i, n)) count++;

        return count;
    }

}