public class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum * 1.0 / k;
    }

    public static void main(String[] args) {
        MaxAverageSubarray sol = new MaxAverageSubarray();

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double result = sol.findMaxAverage(nums, k);

        System.out.println("Maximum Average of Subarray of length " + k + " is: " + result);
        // Expected Output: 12.75
    }
}
