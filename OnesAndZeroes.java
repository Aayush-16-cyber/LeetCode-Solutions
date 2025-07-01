import java.util.*;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        OnesAndZeroes solution = new OnesAndZeroes();

        String[] strs1 = {"10", "0001", "111001", "1", "0"};
        int m1 = 5, n1 = 3;
        System.out.println("Input: strs = {\"10\", \"0001\", \"111001\", \"1\", \"0\"}, m = 5, n = 3");
        System.out.println("Output: " + solution.findMaxForm(strs1, m1, n1)); // Output: 4

        String[] strs2 = {"10", "0", "1"};
        int m2 = 1, n2 = 1;
        System.out.println("\nInput: strs = {\"10\", \"0\", \"1\"}, m = 1, n = 1");
        System.out.println("Output: " + solution.findMaxForm(strs2, m2, n2)); // Output: 2
    }
}
