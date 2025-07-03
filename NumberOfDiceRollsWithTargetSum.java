public class NumberOfDiceRollsWithTargetSum {
    private static final int MOD = 1_000_000_007;

    public static int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int dice = 1; dice <= n; dice++) {
            for (int t = 1; t <= target; t++) {
                for (int face = 1; face <= k; face++) {
                    if (t - face >= 0) {
                        dp[dice][t] = (dp[dice][t] + dp[dice - 1][t - face]) % MOD;
                    }
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int n = 2, k = 6, target = 7;
        int ways = numRollsToTarget(n, k, target);
        System.out.println("Number of ways: " + ways); // Output: 6
    }
}
