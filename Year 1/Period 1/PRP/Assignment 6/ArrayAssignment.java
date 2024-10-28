import java.util.HashSet;

public class ArrayAssignment {
    private static void diagonalPrint(int[][] M, int s, int i) {
        int width = M.length;
        int height = M[0].length;

        int biggestSum = width + height - 2;
        if (!(s - i > width - 1 || i > height - 1)) System.out.print(M[s - i][i] + " ");

        if (i + 1 <= s) diagonalPrint(M, s, i + 1);
        else if (s + 1 <= biggestSum) diagonalPrint(M, s + 1, 0);
    }

    public static void diagonalPrint(int[][] M) {
        diagonalPrint(M, 0, 0);
    }

    private static int allNumsWithin(int[] A, int k, int startIndex, int index, HashSet<Integer> choicesFound, int minimumResult) {
        if (startIndex == A.length) return minimumResult == 999999999 ? 0 : minimumResult;
        if (index == A.length) return allNumsWithin(A, k, startIndex + 1, startIndex + 1, new HashSet<Integer>(), minimumResult);

        choicesFound.add(A[index]);
        if (choicesFound.size() == k) {
            int newMinimumResult = index - startIndex + 1;
            minimumResult = newMinimumResult < minimumResult ? newMinimumResult : minimumResult;

            return allNumsWithin(A, k, startIndex + 1, startIndex + 1, new HashSet<Integer>(), minimumResult);
        } else return allNumsWithin(A, k, startIndex, index + 1, choicesFound, minimumResult);
        
    }

    public static int allNumsWithin(int[] A, int k) {
        return allNumsWithin(A, k, 0, 0, new HashSet<Integer>(), 999999999);
    }

    public static void main(String[] args) {
        int[][] M = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        diagonalPrint(M);
        System.out.println();

        int[] A = {0,2,0,2,0,2,2,1,1,0};
        System.out.println(allNumsWithin(A, 3));

        int[] B = {0,1,1,4,0,2,0,1,0,2};
        System.out.println(allNumsWithin(B, 5));

        int[] C = {1,2,2,2,2,2,2,0};
        System.out.println(allNumsWithin(C, 3));
    }
}
