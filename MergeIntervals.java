import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            // If result is empty or no overlap, just add
            if (result.size() == 0 || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                // Merge overlapping intervals
                result.get(result.size() - 1)[1] = Math.max(
                    result.get(result.size() - 1)[1], interval[1]
                );
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] merged = solution.merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
