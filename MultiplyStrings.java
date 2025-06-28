public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] product = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + product[i + j + 1];
                product[i + j + 1] = sum % 10;
                product[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int num : product) {
            if (!(result.length() == 0 && num == 0)) {
                result.append(num);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Example 1
        String num1 = "2", num2 = "3";
        System.out.println("Product: " + multiply(num1, num2)); // Output: "6"

        // Example 2
        String num3 = "123", num4 = "456";
        System.out.println("Product: " + multiply(num3, num4)); // Output: "56088"

        // Example 3
        String num5 = "0", num6 = "789";
        System.out.println("Product: " + multiply(num5, num6)); // Output: "0"
    }
}
