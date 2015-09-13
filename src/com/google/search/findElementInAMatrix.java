package com.google.search;

// The performance is O(lg (sqrt(M^2+N^2) * log (N+M) ))
public class findElementInAMatrix {
    public static int[] findElementInMatrix(int[][] matrix, int elementToFind) {
        final int M = matrix.length;
        final int N = matrix[0].length;

        int[] upperDiagonalLimit = findUpperDiagonalLimit(matrix, M, N, elementToFind);
        int[] lowerDiagonalLimit = getLowerLimit(N, M, upperDiagonalLimit);

        if (matrix[lowerDiagonalLimit[0]][lowerDiagonalLimit[1]] == elementToFind) {
            return lowerDiagonalLimit;
        } else if (matrix[upperDiagonalLimit[0]][upperDiagonalLimit[1]] == elementToFind) {
            return upperDiagonalLimit;
        }

        return findElementInDiagonal(matrix, lowerDiagonalLimit, upperDiagonalLimit, elementToFind);
    }

    private static int[] findElementInDiagonal(int[][] matrix, int[] lowerDL, int[] upperDL, int x) {
        int[] middle = {(lowerDL[0] + upperDL[0]) / 2, (lowerDL[1] + upperDL[1]) / 2};

        if (matrix[middle[0]][middle[1]] == x) {
            return middle;
        } else if (x < matrix[middle[0]][middle[1]]) {
            return findElementInDiagonal(matrix, lowerDL, middle, x);
        } else if (matrix[middle[0]][middle[1]] > x) {
            return findElementInDiagonal(matrix, middle, upperDL, x);
        }

        return new int[]{-1, -1};
    }


    private static int[] getLowerLimit(int n, int m, int[] upperDiagonalLimit) {
        return new int[]{};
    }

    private static int[] findUpperDiagonalLimit(int[][] matrix, int M, int N, int x) {
        for (int i = 0; i < M; i++) {
            if (matrix[0][i] >= x) {
                return new int[]{0, i};
            }
        }

        for (int j = 0; j < N; j++) {
            if (matrix[M][j] > x) {
                return new int[]{M, j};
            }
        }
        return new int[]{-1, -1};
    }

}
