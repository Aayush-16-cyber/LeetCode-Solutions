import java.util.*;

public class IsGraphBipartite {

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0 = unvisited, 1 = red, -1 = blue

        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(graph, color, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int[] color, int node, int c) {
        if (color[node] != 0) return color[node] == c;

        color[node] = c;
        for (int neighbor : graph[node]) {
            if (!dfs(graph, color, neighbor, -c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph1)); // false

        int[][] graph2 = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph2)); // true
    }
}
