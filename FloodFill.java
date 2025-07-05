public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        if (startColor != color) {
            dfs(image, sr, sc, startColor, color);
        }
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int startColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != startColor) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r - 1, c, startColor, newColor);
        dfs(image, r + 1, c, startColor, newColor);
        dfs(image, r, c - 1, startColor, newColor);
        dfs(image, r, c + 1, startColor, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;
        int[][] result = floodFill(image, sr, sc, color);

        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
