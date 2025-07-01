import java.util.*;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int totalWeight = 0;
        for (int stone : stones) {
            totalWeight += stone;
        }

        int target = totalWeight / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        for (int j = target; j >= 0; j--) {
            if (dp[j]) {
                return totalWeight - 2 * j;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LastStoneWeightII solution = new LastStoneWeightII();

        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("Input: stones = [2, 7, 4, 1, 8, 1]");
        System.out.println("Output: " + solution.lastStoneWeightII(stones1)); // Output: 1

        int[] stones2 = {31, 26, 33, 21, 40};
        System.out.println("\nInput: stones = [31, 26, 33, 21, 40]");
        System.out.println("Output: " + solution.lastStoneWeightII(stones2)); // Output: 5
    }
}
