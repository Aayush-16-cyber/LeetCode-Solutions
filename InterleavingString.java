public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                               (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println("Is Interleaving: " + isInterleave(s1, s2, s3)); // Output: true

        // Example 2
        s1 = "aabcc"; s2 = "dbbca"; s3 = "aadbbbaccc";
        System.out.println("Is Interleaving: " + isInterleave(s1, s2, s3)); // Output: false

        // Example 3
        s1 = ""; s2 = ""; s3 = "";
        System.out.println("Is Interleaving: " + isInterleave(s1, s2, s3)); // Output: true
    }
}
