import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int required = mapT.size();
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] result = {-1, 0, 0}; // length, left, right

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (mapT.containsKey(c) && windowCounts.get(c).intValue() == mapT.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);

                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (mapT.containsKey(c) && windowCounts.get(c) < mapT.get(c)) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Minimum window substring: " + minWindow(s1, t1));

        String s2 = "a";
        String t2 = "a";
        System.out.println("Minimum window substring: " + minWindow(s2, t2));

        String s3 = "a";
        String t3 = "aa";
        System.out.println("Minimum window substring: " + minWindow(s3, t3));
    }
}
