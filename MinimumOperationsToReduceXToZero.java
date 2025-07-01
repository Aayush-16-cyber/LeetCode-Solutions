public class MinimumOperationsToReduceXToZero {

    public static int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;
        if (target < 0) return -1;

        int n = nums.length;
        int currentSum = 0;
        int maxLength = -1;

        for (int start = 0, end = 0; end < n; end++) {
            currentSum += nums[end];

            while (currentSum > target && start <= end) {
                currentSum -= nums[start++];
            }

            if (currentSum == target) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength == -1 ? -1 : n - maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 4, 2, 3};
        int x1 = 5;
        System.out.println("Input: " + x1 + " Output: " + minOperations(nums1, x1)); // 2

        int[] nums2 = {5, 6, 7, 8, 9};
        int x2 = 4;
        System.out.println("Input: " + x2 + " Output: " + minOperations(nums2, x2)); // -1

        int[] nums3 = {3, 2, 20, 1, 1, 3};
        int x3 = 10;
        System.out.println("Input: " + x3 + " Output: " + minOperations(nums3, x3)); // 5
    }
}
