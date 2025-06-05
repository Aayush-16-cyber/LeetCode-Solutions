public class PivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == (totalSum - leftSum - nums[i])) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        PivotIndex sol = new PivotIndex();

        int[] nums = {1, 7, 3, 6, 5, 6}; // Example input
        int result = sol.pivotIndex(nums);

        System.out.println("Pivot Index: " + result); // Expected: 3
    }
}
