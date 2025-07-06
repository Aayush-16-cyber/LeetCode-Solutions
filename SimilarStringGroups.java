import java.util.*;

public class SimilarStringGroups {

    public static void main(String[] args) {
        String[] strs1 = {"tars", "rats", "arts", "star"};
        String[] strs2 = {"omv", "ovm"};

        System.out.println("Groups in strs1: " + numSimilarGroups(strs1)); // Output: 2
        System.out.println("Groups in strs2: " + numSimilarGroups(strs2)); // Output: 1
    }

    public static int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count();
    }

    private static boolean isSimilar(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2) return false;
            }
        }

        return diff == 0 || diff == 2;
    }

    static class UnionFind {
        int[] parent;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                parent[px] = py;
                count--;
            }
        }

        int count() {
            return count;
        }
    }
}
