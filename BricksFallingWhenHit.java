import java.util.*;

public class BricksFallingWhenHit {
    static int rows, cols;
    static int[][] grid;
    static int[] parent, size;
    static final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
    static final int TOP = 0;

    public static void main(String[] args) {
        int[][] grid1 = {{1,0,0,0},{1,1,1,0}};
        int[][] hits1 = {{1,0}};
        System.out.println(hitBricks(grid1, hits1)); // [2]

        int[][] grid2 = {{1,0,0,0},{1,1,0,0}};
        int[][] hits2 = {{1,1},{1,0}};
        System.out.println(hitBricks(grid2, hits2)); // [0, 0]
    }

    public static List<Integer> hitBricks(int[][] inputGrid, int[][] hits) {
        grid = inputGrid;
        rows = grid.length;
        cols = grid[0].length;

        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; ++i)
            copy[i] = grid[i].clone();

        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }

        parent = new int[rows * cols + 1];
        size = new int[rows * cols + 1];
        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (copy[r][c] == 1) {
                    int idx = index(r, c);
                    if (r == 0) union(idx, TOP);
                    for (int[] d : DIRS) {
                        int nr = r + d[0], nc = c + d[1];
                        if (inBounds(nr, nc) && copy[nr][nc] == 1) {
                            union(idx, index(nr, nc));
                        }
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = hits.length - 1; i >= 0; --i) {
            int r = hits[i][0], c = hits[i][1];
            if (grid[r][c] == 0) {
                res.add(0);
                continue;
            }

            int prevTop = size[find(TOP)];
            int idx = index(r, c);
            copy[r][c] = 1;

            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (inBounds(nr, nc) && copy[nr][nc] == 1) {
                    union(idx, index(nr, nc));
                }
            }

            if (r == 0) union(idx, TOP);
            int newTop = size[find(TOP)];
            res.add(Math.max(0, newTop - prevTop - 1));
        }

        Collections.reverse(res);
        return res;
    }

    static int index(int r, int c) {
        return r * cols + c + 1;
    }

    static boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx != ry) {
            parent[rx] = ry;
            size[ry] += size[rx];
        }
    }
}
