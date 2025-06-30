import java.util.*;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            int pos = Collections.binarySearch(sub, num);
            if (pos < 0) pos = -(pos + 1);
            if (pos < sub.size()) {
                sub.set(pos, num);
            } else {
                sub.add(num);
            }
        }
        return sub.size();
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums)); // Output: 4
    }
}
