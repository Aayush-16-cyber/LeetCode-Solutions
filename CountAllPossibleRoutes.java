public class CountAllPossibleRoutes {
    static final int MOD = 1_000_000_007;
    static Integer[][] dp;

    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        dp = new Integer[n][fuel + 1];
        return dfs(locations, start, finish, fuel);
    }

    private static int dfs(int[] loc, int pos, int finish, int fuel) {
        if (fuel < 0) return 0;
        if (dp[pos][fuel] != null) return dp[pos][fuel];

        int ans = (pos == finish) ? 1 : 0;

        for (int i = 0; i < loc.length; i++) {
            if (i == pos) continue;
            int cost = Math.abs(loc[pos] - loc[i]);
            if (fuel >= cost) {
                ans = (ans + dfs(loc, i, finish, fuel - cost)) % MOD;
            }
        }

        return dp[pos][fuel] = ans;
    }

    public static void main(String[] args) {
        System.out.println(countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5));  // Output: 4
        System.out.println(countRoutes(new int[]{4, 3, 1}, 1, 0, 6));        // Output: 5
        System.out.println(countRoutes(new int[]{5, 2, 1}, 0, 2, 3));        // Output: 0
    }
}
