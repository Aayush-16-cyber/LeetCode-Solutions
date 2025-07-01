public class CoinChangeII {

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        // Example 1
        int amount1 = 5;
        int[] coins1 = {1, 2, 5};
        System.out.println("Number of combinations: " + change(amount1, coins1)); // Output: 4

        // Example 2
        int amount2 = 3;
        int[] coins2 = {2};
        System.out.println("Number of combinations: " + change(amount2, coins2)); // Output: 0

        // Example 3
        int amount3 = 10;
        int[] coins3 = {10};
        System.out.println("Number of combinations: " + change(amount3, coins3)); // Output: 1
    }
}
