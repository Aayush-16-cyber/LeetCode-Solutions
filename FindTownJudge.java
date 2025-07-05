public class FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trustScores = new int[n + 1];

        for (int[] t : trust) {
            trustScores[t[0]]--;
            trustScores[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    // Test cases
    public static void main(String[] args) {
        FindTownJudge sol = new FindTownJudge();

        int[][] trust1 = {{1, 2}};
        int[][] trust2 = {{1, 3}, {2, 3}};
        int[][] trust3 = {{1, 3}, {2, 3}, {3, 1}};

        System.out.println(sol.findJudge(2, trust1)); // Output: 2
        System.out.println(sol.findJudge(3, trust2)); // Output: 3
        System.out.println(sol.findJudge(3, trust3)); // Output: -1
    }
}
