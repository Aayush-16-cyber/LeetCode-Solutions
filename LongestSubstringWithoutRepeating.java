import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }

            charIndexMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "abcabcbb";
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(s1)); // Output: 3

        // Example 2
        String s2 = "bbbbb";
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(s2)); // Output: 1

        // Example 3
        String s3 = "pwwkew";
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(s3)); // Output: 3
    }
}
