public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true; // Empty string matches empty pattern
        
        // Handle patterns starting with '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);
                
                if (pChar == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pChar == '?' || sChar == pChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        System.out.println(isMatch(s, p)); // Output: true
    }
}
