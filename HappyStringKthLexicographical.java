import java.util.*;

public class HappyStringKthLexicographical {
    public static String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n);
        return result.size() >= k ? result.get(k - 1) : "";
    }

    private static void backtrack(List<String> result, String current, int n) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (current.length() == 0 || current.charAt(current.length() - 1) != ch) {
                backtrack(result, current + ch, n);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3, k = 9;
        System.out.println("K-th happy string: " + getHappyString(n, k));
    }
}
