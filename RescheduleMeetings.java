import java.util.*;

public class RescheduleMeetings {
    public static void main(String[] args) {
        System.out.println(maxFreeTime(5, new int[]{1, 3}, new int[]{2, 5}));           // 2
        System.out.println(maxFreeTime(10, new int[]{0, 7, 9}, new int[]{1, 8, 10}));    // 7
        System.out.println(maxFreeTime(10, new int[]{0, 3, 7, 9}, new int[]{1, 4, 8, 10})); // 6
        System.out.println(maxFreeTime(5, new int[]{0,1,2,3,4}, new int[]{1,2,3,4,5}));  // 0
    }

    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] duration = new int[n];
        for (int i = 0; i < n; ++i)
            duration[i] = endTime[i] - startTime[i];

        int[] gaps = new int[n + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < n; ++i)
            gaps[i] = startTime[i] - endTime[i - 1];
        gaps[n] = eventTime - endTime[n - 1];

        int maxGap = 0;
        for (int g : gaps) maxGap = Math.max(maxGap, g);

        for (int i = 0; i < n; ++i) {
            int dur = duration[i];

            for (int j = 0; j <= n; ++j) {
                int freeStart = (j == 0) ? 0 : endTime[j - 1];
                int freeEnd = (j == n) ? eventTime : startTime[j];

                if (j == i || j == i + 1) continue;

                if (freeEnd - freeStart >= dur) {
                    int tempStart = freeStart;
                    int tempEnd = tempStart + dur;

                    List<int[]> meetings = new ArrayList<>();
                    for (int k = 0; k < n; ++k) {
                        if (k == i) continue;
                        meetings.add(new int[]{startTime[k], endTime[k]});
                    }
                    meetings.add(new int[]{tempStart, tempEnd});
                    meetings.sort((a, b) -> a[0] - b[0]);

                    int maxFree = meetings.get(0)[0];
                    for (int k = 1; k < meetings.size(); ++k)
                        maxFree = Math.max(maxFree, meetings.get(k)[0] - meetings.get(k - 1)[1]);
                    maxFree = Math.max(maxFree, eventTime - meetings.get(meetings.size() - 1)[1]);

                    maxGap = Math.max(maxGap, maxFree);
                }
            }
        }

        return maxGap;
    }
}
