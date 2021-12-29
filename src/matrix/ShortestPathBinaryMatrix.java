package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    // 1091
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        int minPath = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int x = queue.peek()[0];
                int y = queue.peek()[1];
                queue.poll();
                if (x == n - 1 && y == n - 1) {
                    return minPath;
                }
                for (int[] dir : directions) {
                    int r = x + dir[0], c = y + dir[1];
                    if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0) {
                        queue.add(new int[]{r, c});
                        grid[r][c] = 1;
                    }
                }
            }
            minPath++;
        }
        return -1;
    }
}
