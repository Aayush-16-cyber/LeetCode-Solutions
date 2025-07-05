import java.util.*;

public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] cand1 = null, cand2 = null;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                cand1 = new int[]{parent[v], v};
                cand2 = new int[]{u, v};
                edge[1] = 0; // mark as invalid
            }
        }

        for (int i = 0; i <= n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (v == 0) continue;

            int pu = find(parent, u);
            if (pu == v) {
                if (cand1 != null) return cand1;
                return edge;
            }
            parent[v] = pu;
        }

        return cand2;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    public static void main(String[] args) {
        RedundantConnectionII solver = new RedundantConnectionII();

        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(solver.findRedundantDirectedConnection(edges1))); // [2, 3]

        int[][] edges2 = {{1,2},{2,3},{3,4},{4,1},{1,5}};
        System.out.println(Arrays.toString(solver.findRedundantDirectedConnection(edges2))); // [4, 1]
    }
}
