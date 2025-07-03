import java.util.*;

public class MaximumProfitInJobScheduling {

    static class Job {
        int start, end, profit;
        Job(int s, int e, int p) {
            start = s; end = e; profit = p;
        }
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++)
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);

        for (Job job : jobs) {
            Integer prev = dp.floorKey(job.start);
            int currProfit = dp.get(prev) + job.profit;
            if (currProfit > dp.lastEntry().getValue()) {
                dp.put(job.end, currProfit);
            }
        }

        return dp.lastEntry().getValue();
    }

    public static void main(String[] args) {
        int[] start1 = {1,2,3,3}, end1 = {3,4,5,6}, profit1 = {50,10,40,70};
        int[] start2 = {1,2,3,4,6}, end2 = {3,5,10,6,9}, profit2 = {20,20,100,70,60};
        int[] start3 = {1,1,1}, end3 = {2,3,4}, profit3 = {5,6,4};

        System.out.println("Output 1: " + jobScheduling(start1, end1, profit1)); // 120
        System.out.println("Output 2: " + jobScheduling(start2, end2, profit2)); // 150
        System.out.println("Output 3: " + jobScheduling(start3, end3, profit3)); // 6
    }
}
