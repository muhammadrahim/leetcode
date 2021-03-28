/*
 * https://leetcode.com/problems/set-matrix-zeroes/
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 * Follow up: O(mn) space complexity is a bad idea, O(m+n) improves but not best, can you do in constant space?
 * Constraints: m == matrix.length, n == matrix[0].length, 1 <= m,n <= 200
 */

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length;j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                setRowToZero(matrix, i);
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                setColToZero(matrix, i);
            }
        }

        if (firstCol) setColToZero(matrix, 0);
        if (firstRow) setRowToZero(matrix, 0);
    }

    void setRowToZero(int[][] matrix, int col) {
        for (int i = 0; i < matrix[col].length; i++) {
            matrix[col][i] = 0;
        }
    }


    void setColToZero(int[][] matrix, int row) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][row] = 0;
        }
    }
}

