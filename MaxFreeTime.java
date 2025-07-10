import java.util.*;

public class MaxFreeTime {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int eventTime = 10;
        int k = 1;
        int[] startTime = {0, 2, 9};
        int[] endTime = {1, 4, 10};
        System.out.println("Max Free Time: " + sol.maxFreeTime(eventTime, k, startTime, endTime));
    }
}

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        
        int low = 0, high = eventTime;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (canAchieve(mid, eventTime, k, startTime, endTime)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean canAchieve(int freeTime, int eventTime, int k, int[] startTime, int[] endTime) {
        int moves = 0;
        int lastEnd = 0;
        for (int i = 0; i < startTime.length; i++) {
            int duration = endTime[i] - startTime[i];
            int desiredStart = lastEnd + freeTime;
            int newStart = Math.max(startTime[i], desiredStart);
            int newEnd = newStart + duration;

            if (newEnd > eventTime) return false;
            if (newStart != startTime[i]) moves++;
            if (moves > k) return false;

            lastEnd = newEnd;
        }
        return true;
    }
}
