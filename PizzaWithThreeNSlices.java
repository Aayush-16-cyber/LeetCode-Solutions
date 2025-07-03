import java.util.*;

public class PizzaWithThreeNSlices {

    public static int maxSizeSlices(int[] slices) {
        int n = slices.length;
        return Math.max(helper(Arrays.copyOfRange(slices, 0, n - 1), n / 3),
                        helper(Arrays.copyOfRange(slices, 1, n), n / 3));
    }

    private static int helper(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j],
                                    (i >= 2 ? dp[i - 2][j - 1] : 0) + arr[i - 1]);
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        int[] slices1 = {1, 2, 3, 4, 5, 6};
        int[] slices2 = {8, 9, 8, 6, 1, 1};

        System.out.println("Max size slices (Ex1): " + maxSizeSlices(slices1)); // 10
        System.out.println("Max size slices (Ex2): " + maxSizeSlices(slices2)); // 16
    }
}
