public class TargetSum {

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If target is not achievable or (sum + target) is odd, return 0
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) {
            return 0;
        }

        int subsetSum = (sum + target) / 2;
        return countSubsets(nums, subsetSum);
    }

    private static int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: one way to make sum 0

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        System.out.println("Number of ways: " + findTargetSumWays(nums1, target1)); // Output: 5

        // Test Case 2
        int[] nums2 = {1};
        int target2 = 1;
        System.out.println("Number of ways: " + findTargetSumWays(nums2, target2)); // Output: 1

        // Test Case 3
        int[] nums3 = {1, 2, 1};
        int target3 = 0;
        System.out.println("Number of ways: " + findTargetSumWays(nums3, target3)); // Output: 2
    }
}
