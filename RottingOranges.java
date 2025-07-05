import java.util.*;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0, minutes = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) queue.offer(new int[]{r, c});
                if (grid[r][c] == 1) fresh++;
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] d : directions) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println(orangesRotting(grid1)); // Output: 4

        int[][] grid2 = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        System.out.println(orangesRotting(grid2)); // Output: -1

        int[][] grid3 = {
            {0,2}
        };
        System.out.println(orangesRotting(grid3)); // Output: 0
    }
}
