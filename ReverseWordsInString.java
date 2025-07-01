public class ReverseWordsInString {

    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) result.append(" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        System.out.println("Example 1: " + reverseWords(s1)); // Output: "blue is sky the"

        String s2 = "  hello world  ";
        System.out.println("Example 2: " + reverseWords(s2)); // Output: "world hello"

        String s3 = "a good   example";
        System.out.println("Example 3: " + reverseWords(s3)); // Output: "example good a"
    }
}
