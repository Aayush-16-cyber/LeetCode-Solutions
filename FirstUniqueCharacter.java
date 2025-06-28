public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "leetcode";
        System.out.println("First Unique Character Index: " + firstUniqChar(s1)); // Output: 0

        // Example 2
        String s2 = "loveleetcode";
        System.out.println("First Unique Character Index: " + firstUniqChar(s2)); // Output: 2

        // Example 3
        String s3 = "aabb";
        System.out.println("First Unique Character Index: " + firstUniqChar(s3)); // Output: -1
    }
}
