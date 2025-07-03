import java.util.*;

public class WordBreakII {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, wordSet, memo);
    }

    private static List<String> dfs(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();

        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordSet) {
            if (s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), wordSet, memo);
                for (String sub : subList) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }

        memo.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        String s1 = "catsanddog";
        List<String> dict1 = Arrays.asList("cat", "cats", "and", "sand", "dog");

        String s2 = "pineapplepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");

        System.out.println("Output 1: " + wordBreak(s1, dict1));
        System.out.println("Output 2: " + wordBreak(s2, dict2));
        System.out.println("Output 3: " + wordBreak(s3, dict3));
    }
}
