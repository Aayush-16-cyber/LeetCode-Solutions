public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Is palindrome: " + isPalindrome(s1)); // Output: true

        // Example 2
        String s2 = "race a car";
        System.out.println("Is palindrome: " + isPalindrome(s2)); // Output: false

        // Example 3
        String s3 = " ";
        System.out.println("Is palindrome: " + isPalindrome(s3)); // Output: true
    }
}
