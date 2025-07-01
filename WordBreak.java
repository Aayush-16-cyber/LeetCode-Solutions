import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Convert list to set for O(1) lookups
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Base case: an empty string can always be segmented

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println("Input: s = \"leetcode\", wordDict = [\"leet\",\"code\"]");
        System.out.println("Output: " + wb.wordBreak(s1, wordDict1)); // Output: true

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println("\nInput: s = \"applepenapple\", wordDict = [\"apple\",\"pen\"]");
        System.out.println("Output: " + wb.wordBreak(s2, wordDict2)); // Output: true

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("\nInput: s = \"catsandog\", wordDict = [\"cats\",\"dog\",\"sand\",\"and\",\"cat\"]");
        System.out.println("Output: " + wb.wordBreak(s3, wordDict3)); // Output: false
    }
}
