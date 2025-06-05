import java.util.Arrays;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        RunningSum sol = new RunningSum();

        int[] nums = {1, 2, 3, 4}; // Sample input
        int[] result = sol.runningSum(nums);

        System.out.println("Running Sum: " + Arrays.toString(result));
    }
}
