public class UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) dp[i][j] += dp[i - 1][j];
                    if (j > 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // Example 1
        int[][] grid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Unique paths: " + uniquePathsWithObstacles(grid1)); // Output: 2

        // Example 2
        int[][] grid2 = {
                {0, 1},
                {0, 0}
        };
        System.out.println("Unique paths: " + uniquePathsWithObstacles(grid2)); // Output: 1

        // Edge Case
        int[][] grid3 = {
                {1, 0},
                {0, 0}
        };
        System.out.println("Unique paths: " + uniquePathsWithObstacles(grid3)); // Output: 0
    }
}
