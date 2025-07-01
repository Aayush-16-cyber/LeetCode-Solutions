import java.util.Stack;

public class BasicCalculator {

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 for positive, -1 for negative

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // Apply sign
                result += stack.pop(); // Add previous result
            }
        }

        result += sign * number; // Add the last number
        return result;
    }

    public static void main(String[] args) {
        String expr1 = "1 + 1";
        String expr2 = " 2-1 + 2 ";
        String expr3 = "(1+(4+5+2)-3)+(6+8)";

        System.out.println("Input: \"" + expr1 + "\" Output: " + calculate(expr1)); // 2
        System.out.println("Input: \"" + expr2 + "\" Output: " + calculate(expr2)); // 3
        System.out.println("Input: \"" + expr3 + "\" Output: " + calculate(expr3)); // 23
    }
}
