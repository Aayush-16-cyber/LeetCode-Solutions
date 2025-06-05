class NumArray {
    int nums[];

    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return nums[right];
        } else {
            return nums[right] - nums[left - 1];
        }
    }
}

public class NumArrayDemo {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        NumArray obj = new NumArray(input);

        int result1 = obj.sumRange(0, 2); // sum of [1,2,3] = 6
        int result2 = obj.sumRange(1, 3); // sum of [2,3,4] = 9

        System.out.println("Sum from index 0 to 2: " + result1);
        System.out.println("Sum from index 1 to 3: " + result2);
    }
}
