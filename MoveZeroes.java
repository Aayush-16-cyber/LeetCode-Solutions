// File name: MoveZeroes.java

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int index = 0; // Pointer for non-zero elements
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0; // Fill remaining positions with 0
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {0, 1, 0, 3, 12};
        int[] nums2 = {0};

        moveZeroes(nums1);
        moveZeroes(nums2);

        System.out.println("Test case 1: " + Arrays.toString(nums1)); // Output: [1, 3, 12, 0, 0]
        System.out.println("Test case 2: " + Arrays.toString(nums2)); // Output: [0]
    }
}
