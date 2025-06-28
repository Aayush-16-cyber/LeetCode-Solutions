// File name: RemoveDuplicatesFromSortedArray.java

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1; // Pointer for unique elements
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int k1 = removeDuplicates(nums1);
        int k2 = removeDuplicates(nums2);

        System.out.println("Test case 1: k = " + k1 + ", nums = " + Arrays.toString(Arrays.copyOf(nums1, k1))); 
        // Output: k = 2, nums = [1, 2]

        System.out.println("Test case 2: k = " + k2 + ", nums = " + Arrays.toString(Arrays.copyOf(nums2, k2))); 
        // Output: k = 5, nums = [0, 1, 2, 3, 4]
    }
}
