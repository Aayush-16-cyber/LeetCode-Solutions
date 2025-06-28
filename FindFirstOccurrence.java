public class FindFirstOccurrence {

    public static int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Example 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("Index of first occurrence: " + strStr(haystack1, needle1)); // Output: 0

        // Example 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println("Index of first occurrence: " + strStr(haystack2, needle2)); // Output: -1
    }
}
