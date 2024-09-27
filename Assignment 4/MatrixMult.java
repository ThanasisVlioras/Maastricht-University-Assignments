public class MatrixMult {
    
    public static void main(String[] args) {
        // double[][] firstMatrix =
        // {
        //     {1, 2},
        //     {3, 4}
        // };
        
        // double[][] secondMatrix =
        // {
        //     {5, 6},
        //     {7, 8}
        // };

        // double[][] firstMatrix =
        // {
        //     {1, 2, 3},
        //     {4, 5, 6}
        // };
        
        // double[][] secondMatrix =
        // {
        //     {7, 8},
        //     {9, 10},
        //     {11, 12}
        // };

        // double[][] firstMatrix =
        // {
        //     {4},
        //     {5},
        //     {6}
        // };
        
        // double[][] secondMatrix =
        // {
        //     {1, 2, 3}
        // };

        // double[][] firstMatrix =
        // {
        //     {1, 2},
        //     {3, 4},
        //     {5, 6},
        //     {7, 8}
        // };
        
        // double[][] secondMatrix =
        // {
        //     {9},
        //     {10}
        // };

        //System.out.println(multiplyMatrices(firstMatrix, secondMatrix)[0][0]);
    }

    public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        if (firstMatrix[0].length != secondMatrix.length) {
            System.out.println("Illegal matrices!");
            return null;
        }

        int resultWidth = secondMatrix[0].length;
        int resultHeight = firstMatrix.length;
        int dotProductCount = firstMatrix[0].length;
        double[][] result = new double[resultHeight][resultWidth];


        for (int x = 0; resultWidth > x; x++) {
            for (int y = 0; resultHeight > y; y++) {
                result[y][x] = 0;
                for (int i = 0; i < dotProductCount; i++) {
                    result[y][x] += firstMatrix[y][i] * secondMatrix[i][x];
                }
            }
        }

        return result;
    }
}
