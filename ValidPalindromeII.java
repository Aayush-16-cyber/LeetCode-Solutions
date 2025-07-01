public class ValidPalindromeII {

    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "abca";
        String s3 = "abc";

        System.out.println("Input: " + s1 + " Output: " + validPalindrome(s1)); // true
        System.out.println("Input: " + s2 + " Output: " + validPalindrome(s2)); // true
        System.out.println("Input: " + s3 + " Output: " + validPalindrome(s3)); // false
    }
}
