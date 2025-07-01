import java.util.Stack;

public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int rows = matrix.length, cols = matrix[0].length;
        int[] heights = new int[cols]; // Array to store the heights of the histogram
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            // Update the histogram heights for the current row
            for (int j = 0; j < cols; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            // Calculate the largest rectangle area for the current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>(); // Monotonic stack to store indices

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // Test Case 1
        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println("Maximal Rectangle Area: " + maximalRectangle(matrix1)); // Output: 6

        // Test Case 2
        char[][] matrix2 = {
            {'0'}
        };
        System.out.println("Maximal Rectangle Area: " + maximalRectangle(matrix2)); // Output: 0

        // Test Case 3
        char[][] matrix3 = {
            {'1'}
        };
        System.out.println("Maximal Rectangle Area: " + maximalRectangle(matrix3)); // Output: 1
    }
}
