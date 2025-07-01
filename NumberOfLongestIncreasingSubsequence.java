import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] lengths = new int[n]; // lengths[i] = length of LIS ending at i
        int[] counts = new int[n];  // counts[i] = number of LIS ending at i
        Arrays.fill(counts, 1);

        int maxLength = 0, result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j]; // reset count
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j]; // add count
                    }
                }
            }
            maxLength = Math.max(maxLength, lengths[i]);
        }

        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLength) {
                result += counts[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 3, 5, 4, 7};
        System.out.println("Number of LIS: " + findNumberOfLIS(nums1)); // Output: 2

        // Test Case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println("Number of LIS: " + findNumberOfLIS(nums2)); // Output: 5
    }
}
