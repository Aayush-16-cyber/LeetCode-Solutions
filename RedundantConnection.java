import java.util.*;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu == pv) {
                return edge;
            }

            parent[pu] = pv;
        }

        return new int[0];
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        RedundantConnection solver = new RedundantConnection();

        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(solver.findRedundantConnection(edges1))); // Output: [2, 3]

        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(solver.findRedundantConnection(edges2))); // Output: [1, 4]
    }
}
