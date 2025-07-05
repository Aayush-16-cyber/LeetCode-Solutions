import java.util.*;

public class MinimumVerticesToReachAllNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasIncoming = new boolean[n];

        for (List<Integer> edge : edges) {
            hasIncoming[edge.get(1)] = true;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasIncoming[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumVerticesToReachAllNodes sol = new MinimumVerticesToReachAllNodes();

        List<List<Integer>> edges1 = Arrays.asList(
            Arrays.asList(0, 1), Arrays.asList(0, 2),
            Arrays.asList(2, 5), Arrays.asList(3, 4),
            Arrays.asList(4, 2)
        );
        List<List<Integer>> edges2 = Arrays.asList(
            Arrays.asList(0, 1), Arrays.asList(2, 1),
            Arrays.asList(3, 1), Arrays.asList(1, 4),
            Arrays.asList(2, 4)
        );

        System.out.println(sol.findSmallestSetOfVertices(6, edges1)); // Output: [0, 3]
        System.out.println(sol.findSmallestSetOfVertices(5, edges2)); // Output: [0, 2, 3]
    }
}
