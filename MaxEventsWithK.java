import java.util.*;

public class MaxEventsWithK {

    public static void main(String[] args) {
        int[][] events1 = {{1,2,4}, {3,4,3}, {2,3,1}};
        int k1 = 2;

        int[][] events2 = {{1,2,4}, {3,4,3}, {2,3,10}};
        int k2 = 2;

        int[][] events3 = {{1,1,1}, {2,2,2}, {3,3,3}, {4,4,4}};
        int k3 = 3;

        System.out.println("Output 1: " + maxValue(events1, k1)); // 7
        System.out.println("Output 2: " + maxValue(events2, k2)); // 10
        System.out.println("Output 3: " + maxValue(events3, k3)); // 9
    }

    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int n = events.length;
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return dfs(events, 0, k, dp);
    }

    private static int dfs(int[][] events, int i, int k, int[][] dp) {
        if (i == events.length || k == 0) return 0;
        if (dp[i][k] != -1) return dp[i][k];

        int next = binarySearch(events, events[i][1]);
        int take = events[i][2] + dfs(events, next, k - 1, dp);
        int skip = dfs(events, i + 1, k, dp);
        return dp[i][k] = Math.max(take, skip);
    }

    private static int binarySearch(int[][] events, int end) {
        int low = 0, high = events.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > end)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
