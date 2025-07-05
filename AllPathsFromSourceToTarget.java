import java.util.*;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, result);
        return result;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int neighbor : graph[node]) {
            path.add(neighbor);
            dfs(graph, neighbor, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget solver = new AllPathsFromSourceToTarget();

        int[][] graph1 = {{1,2},{3},{3},{}};
        System.out.println(solver.allPathsSourceTarget(graph1));

        int[][] graph2 = {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(solver.allPathsSourceTarget(graph2));
    }
}
