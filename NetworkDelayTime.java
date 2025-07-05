import java.util.*;

public class NetworkDelayTime {

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] time : times) {
            graph[time[0]].add(new int[]{time[1], time[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];

            if (time > dist[node]) continue;

            for (int[] nei : graph[node]) {
                int next = nei[0], wt = nei[1];
                if (dist[node] + wt < dist[next]) {
                    dist[next] = dist[node] + wt;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] times1 = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(times1, 4, 2)); // Output: 2

        int[][] times2 = {{1,2,1}};
        System.out.println(networkDelayTime(times2, 2, 1)); // Output: 1

        int[][] times3 = {{1,2,1}};
        System.out.println(networkDelayTime(times3, 2, 2)); // Output: -1
    }
}
