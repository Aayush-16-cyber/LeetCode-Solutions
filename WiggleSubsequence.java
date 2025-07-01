public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int up = 1;   // Tracks wiggle ending with a positive difference
        int down = 1; // Tracks wiggle ending with a negative difference

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }

    public static void main(String[] args) {
        WiggleSubsequence ws = new WiggleSubsequence();

        int[] nums1 = {1, 7, 4, 9, 2, 5};
        System.out.println("Input: {1, 7, 4, 9, 2, 5}");
        System.out.println("Output: " + ws.wiggleMaxLength(nums1)); // Output: 6

        int[] nums2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println("\nInput: {1, 17, 5, 10, 13, 15, 10, 5, 16, 8}");
        System.out.println("Output: " + ws.wiggleMaxLength(nums2)); // Output: 7

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\nInput: {1, 2, 3, 4, 5, 6, 7, 8, 9}");
        System.out.println("Output: " + ws.wiggleMaxLength(nums3)); // Output: 2
    }
}
