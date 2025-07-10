import java.util.*;

public class MaxFreeTimeSolver {
    public static void main(String[] args) {
        int eventTime = 10;
        int k = 1;
        int[] startTime = {0, 2, 9};
        int[] endTime = {1, 4, 10};

        Solution sol = new Solution();
        int result = sol.maxFreeTime(eventTime, k, startTime, endTime);
        System.out.println("Max Free Time: " + result);
    }
}

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int low = 0, high = eventTime;

        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (canFit(mid, k, eventTime, startTime, endTime)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean canFit(int gap, int k, int eventTime, int[] start, int[] end) {
        int moves = 0;
        int curTime = 0;
        int n = start.length;

        for (int i = 0; i < n; i++) {
            int dur = end[i] - start[i];
            int newStart = Math.max(curTime + gap, start[i]);
            int newEnd = newStart + dur;

            if (newEnd > eventTime) return false;
            if (newStart != start[i]) moves++;
            if (moves > k) return false;

            curTime = newEnd;
        }

        return true;
    }
}
