package leetcode;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int largestSquare = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    memo[i][j] = 1;
                    largestSquare = 1;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int val = Math.min(Math.min(memo[i-1][j], memo[i][j-1]), memo[i-1][j-1]);
                    memo[i][j] = val + 1;
                    largestSquare = Math.max(
                            val + 1,
                            largestSquare
                    );
                }
            }
        }
        return largestSquare*largestSquare;
    }
}
