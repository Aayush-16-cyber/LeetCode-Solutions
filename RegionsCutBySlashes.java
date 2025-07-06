import java.util.*;

class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        // Each cell is divided into 4 triangles
        int size = n * 3;
        int[][] expanded = new int[size][size];

        // Fill the expanded grid
        for (int i = 0; i < n; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                char c = row[j];
                if (c == '/') {
                    expanded[i * 3][j * 3 + 2] = 1;
                    expanded[i * 3 + 1][j * 3 + 1] = 1;
                    expanded[i * 3 + 2][j * 3] = 1;
                } else if (c == '\\') {
                    expanded[i * 3][j * 3] = 1;
                    expanded[i * 3 + 1][j * 3 + 1] = 1;
                    expanded[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }

        // Count regions using DFS
        boolean[][] visited = new boolean[size][size];
        int regions = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (expanded[i][j] == 0 && !visited[i][j]) {
                    dfs(expanded, visited, i, j);
                    regions++;
                }
            }
        }

        return regions;
    }

    private void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int n = grid.length;
        if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 1 || visited[x][y]) return;
        visited[x][y] = true;
        dfs(grid, visited, x + 1, y);
        dfs(grid, visited, x - 1, y);
        dfs(grid, visited, x, y + 1);
        dfs(grid, visited, x, y - 1);
    }
}
