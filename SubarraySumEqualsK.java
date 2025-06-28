// File name: SubarraySumEqualsK.java

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1); // Base case for when sum equals k directly

        for (int num : nums) {
            sum += num;
            if (prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum - k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 1, 1};
        int k1 = 2;

        int[] nums2 = {1, 2, 3};
        int k2 = 3;

        System.out.println("Test case 1: " + subarraySum(nums1, k1)); // Output: 2
        System.out.println("Test case 2: " + subarraySum(nums2, k2)); // Output: 2
    }
}
