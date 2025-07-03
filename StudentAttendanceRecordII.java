public class StudentAttendanceRecordII {
    static final int MOD = 1_000_000_007;

    public static int checkRecord(int n) {
        long[][] dp = new long[n + 1][3]; // dp[i][j] = # of records of length i ending with j L's, no A
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // Ending with 'P'
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            // Ending with 'L'
            dp[i][1] = dp[i-1][0];
            dp[i][2] = dp[i-1][1];
        }

        long res = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;

        for (int i = 0; i < n; i++) {
            long left = (dp[i][0] + dp[i][1] + dp[i][2]) % MOD;
            long right = (dp[n - i - 1][0] + dp[n - i - 1][1] + dp[n - i - 1][2]) % MOD;
            res = (res + (left * right) % MOD) % MOD;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println("Input: 1 -> Output: " + checkRecord(1));       // 3
        System.out.println("Input: 2 -> Output: " + checkRecord(2));       // 8
        System.out.println("Input: 10101 -> Output: " + checkRecord(10101)); // 183236316
    }
}
