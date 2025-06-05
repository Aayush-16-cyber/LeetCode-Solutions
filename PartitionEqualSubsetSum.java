import java.util.*;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If sum is odd, partitioning into equal subsets is impossible
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return helper(nums, 0, target, dp);
    }

    boolean helper(int[] nums, int index, int target, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index >= nums.length || target < 0) {
            return false;
        }
        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean pickIt = helper(nums, index + 1, target - nums[index], dp);
        boolean notPickIt = helper(nums, index + 1, target, dp);

        return dp[index][target] = pickIt || notPickIt;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum sol = new PartitionEqualSubsetSum();

        int[] nums = {1, 5, 11, 5}; // Sample input
        boolean result = sol.canPartition(nums);

        System.out.println("Can partition into two equal subsets? " + result);
    }
}
