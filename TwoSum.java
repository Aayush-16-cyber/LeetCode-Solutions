import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] aux = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int firstvalue = -1;
        int secondvalue = -1;

        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                firstvalue = nums[left];
                secondvalue = nums[right];
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < aux.length; i++) {
            if (firstIndex == -1 && aux[i] == firstvalue) {
                firstIndex = i;
            } else if (secondIndex == -1 && aux[i] == secondvalue) {
                secondIndex = i;
            }
        }

        return new int[]{firstIndex, secondIndex};
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = sol.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
