public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // Example 1
        int[] cost1 = {10, 15, 20};
        System.out.println("Minimum cost to reach the top: " + minCostClimbingStairs(cost1)); // Output: 15

        // Example 2
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Minimum cost to reach the top: " + minCostClimbingStairs(cost2)); // Output: 6

        // Additional Test Case
        int[] cost3 = {0, 0, 0, 0};
        System.out.println("Minimum cost to reach the top: " + minCostClimbingStairs(cost3)); // Output: 0
    }
}
