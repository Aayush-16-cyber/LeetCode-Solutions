public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        // Kadane's Algorithm
        int maxSum = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubarray sol = new MaxSubarray();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = sol.maxSubArray(nums);

        System.out.println("Maximum Subarray Sum is: " + result);
        // Expected Output: 6 (Subarray = [4, -1, 2, 1])
    }
}
