package matrix;

public class MaxAreaIsland {
    // 695
    int[] direction = new int[]{-1, 0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        int area = 1;
        for (int i = 0; i < 4; ++i) {
            int r = x + direction[i], c = y + direction[i + 1];
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
                area += dfs(grid, r, c);
            }
        }
        return area;
    }

}
