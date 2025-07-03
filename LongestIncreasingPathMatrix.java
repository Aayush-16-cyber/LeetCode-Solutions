public class LongestIncreasingPathMatrix {
    private static final int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private static int m, n;

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;

        int[][] memo = new int[m][n];
        int maxLen = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, memo));
            }
        }

        return maxLen;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) return memo[i][j];

        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];

            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, 1 + dfs(matrix, x, y, memo));
            }
        }

        memo[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        System.out.println("Longest Increasing Path: " + longestIncreasingPath(matrix));
    }
}
