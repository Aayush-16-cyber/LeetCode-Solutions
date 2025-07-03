public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = matrix[i + 1][j];
                int left = j > 0 ? matrix[i + 1][j - 1] : Integer.MAX_VALUE;
                int right = j < n - 1 ? matrix[i + 1][j + 1] : Integer.MAX_VALUE;
                matrix[i][j] += Math.min(down, Math.min(left, right));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int val : matrix[0]) {
            min = Math.min(min, val);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        System.out.println("Minimum Falling Path Sum: " + minFallingPathSum(matrix)); // Output: 13
    }
}
