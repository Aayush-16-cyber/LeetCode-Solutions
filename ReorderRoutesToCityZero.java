import java.util.*;

public class ReorderRoutesToCityZero {

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] conn : connections) {
            graph.computeIfAbsent(conn[0], x -> new ArrayList<>()).add(new int[]{conn[1], 1}); // original direction
            graph.computeIfAbsent(conn[1], x -> new ArrayList<>()).add(new int[]{conn[0], 0}); // reverse direction
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, Map<Integer, List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            int next = neighbor[0];
            int needsChange = neighbor[1];

            if (!visited[next]) {
                changes += needsChange + dfs(next, graph, visited);
            }
        }

        return changes;
    }

    public static void main(String[] args) {
        ReorderRoutesToCityZero sol = new ReorderRoutesToCityZero();

        int[][] conn1 = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int[][] conn2 = {{1,0},{1,2},{3,2},{3,4}};
        int[][] conn3 = {{1,0},{2,0}};

        System.out.println(sol.minReorder(6, conn1)); // Output: 3
        System.out.println(sol.minReorder(5, conn2)); // Output: 2
        System.out.println(sol.minReorder(3, conn3)); // Output: 0
    }
}
