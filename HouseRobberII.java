public class HouseRobberII {

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    private static int robHelper(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2, 3, 2};
        System.out.println("Maximum amount robbed: " + rob(nums1)); // Output: 3

        // Example 2
        int[] nums2 = {1, 2, 3, 1};
        System.out.println("Maximum amount robbed: " + rob(nums2)); // Output: 4

        // Example 3
        int[] nums3 = {1, 2, 3};
        System.out.println("Maximum amount robbed: " + rob(nums3)); // Output: 3
    }
}
