public class BurstBalloons {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] extended = new int[n + 2];
        extended[0] = extended[n + 1] = 1;
        System.arraycopy(nums, 0, extended, 1, n);

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                        dp[i][k - 1] + extended[i - 1] * extended[k] * extended[j + 1] + dp[k + 1][j]);
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums)); // Output: 167
    }
}
