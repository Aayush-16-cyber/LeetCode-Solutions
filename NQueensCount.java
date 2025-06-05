public class NQueensCount {
    boolean board[][];

    public int totalNQueens(int n) {
        board = new boolean[n][n];
        return helper(0, n);
    }

    boolean canIPlaceAQueen(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }

        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) return false;
        }

        return true;
    }

    int helper(int row, int n) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (canIPlaceAQueen(row, col)) {
                board[row][col] = true;
                count += helper(row + 1, n);
                board[row][col] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NQueensCount sol = new NQueensCount();

        int n = 4; // Sample input
        int result = sol.totalNQueens(n);

        System.out.println("Total number of valid N-Queens solutions for n = " + n + ": " + result);
    }
}
