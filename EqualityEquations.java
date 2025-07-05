import java.util.*;

public class EqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) parent[i] = i;

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                union(parent, x, y);
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                if (find(parent, x) == find(parent, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }

    public static void main(String[] args) {
        EqualityEquations solver = new EqualityEquations();

        String[] equations1 = {"a==b", "b!=a"};
        System.out.println(solver.equationsPossible(equations1)); // false

        String[] equations2 = {"b==a", "a==b"};
        System.out.println(solver.equationsPossible(equations2)); // true

        String[] equations3 = {"a==b", "b==c", "a!=c"};
        System.out.println(solver.equationsPossible(equations3)); // false
    }
}
