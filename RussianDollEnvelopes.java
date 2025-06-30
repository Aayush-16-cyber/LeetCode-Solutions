import java.util.Arrays;

public class RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        // Sort by width ascending and height descending if widths are equal
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // Extract heights and find LIS
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        return lengthOfLIS(heights);
    }

    private static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == len) {
                len++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[][] envelopes1 = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println("Maximum Envelopes (Example 1): " + maxEnvelopes(envelopes1)); // Output: 3

        int[][] envelopes2 = {{1, 1}, {1, 1}, {1, 1}};
        System.out.println("Maximum Envelopes (Example 2): " + maxEnvelopes(envelopes2)); // Output: 1
    }
}
