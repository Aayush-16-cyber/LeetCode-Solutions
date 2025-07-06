import java.util.*;

public class ShortestPathVisitingAllNodes {

    public static void main(String[] args) {
        int[][] graph1 = {{1,2,3},{0},{0},{0}};
        int[][] graph2 = {{1},{0,2,4},{1,3,4},{2},{1,2}};

        System.out.println("Output 1: " + shortestPathLength(graph1)); // Output: 4
        System.out.println("Output 2: " + shortestPathLength(graph2)); // Output: 4
    }

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int mask = (1 << i);
            queue.offer(new int[]{i, mask, 0});
            visited.add(i + "," + mask);
        }

        int target = (1 << n) - 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], mask = curr[1], dist = curr[2];

            if (mask == target) return dist;

            for (int nei : graph[node]) {
                int nextMask = mask | (1 << nei);
                String key = nei + "," + nextMask;
                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.offer(new int[]{nei, nextMask, dist + 1});
                }
            }
        }

        return -1;
    }
}
