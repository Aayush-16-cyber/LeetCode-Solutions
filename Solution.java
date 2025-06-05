public class Solution {

    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                high = mid; // peak can be mid or on left
            } else {
                low = mid + 1; // peak is on right
            }
        }

        return low; // or return high; dono same hoga
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {3, 22, 2, 12, 6, 8, 9, 11, 10};
        int peakIndex = sol.findPeakElement(nums);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + nums[peakIndex]);
    }
}
