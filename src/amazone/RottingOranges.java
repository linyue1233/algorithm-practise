package amazone;

import java.util.Deque;
import java.util.LinkedList;

public class RottingOranges {
    //994
    public int orangesRotting(int[][] grid) {
        // BFS
        int[] directions = new int[]{-1,0,1,0,-1};
        int m = grid.length, n = grid[0].length;
        Deque<int[]> deque = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int freshNum = 0;
        int ans = 0;
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                if(grid[i][j] == 1){
                    freshNum++;
                }
                if( grid[i][j] == 2){
                    visited[i][j] = true;
                    deque.offerLast(new int[]{i,j});
                }
            }
        }
        if(freshNum == 0) return 0;
        while( !deque.isEmpty() ){
            int size = deque.size();
            ans++;
            for(int i = 0;i<size;++i){
                int t1 = deque.peekFirst()[0];
                int t2 = deque.peekFirst()[1];
                deque.pollFirst();
                for(int k = 0;k<4;++k){
                    int x = t1+directions[k], y = t2+directions[k+1];
                    if( x<0 || x>=m || y<0 || y>=n || visited[x][y]){
                        continue;
                    }
                    visited[x][y] = true;
                    if( grid[x][y] == 1){
                        freshNum--;
                        grid[x][y] = 2;
                        deque.offerLast(new int[]{x,y});
                    }
                }
            }
        }

        return freshNum == 0 ? ans-1 : -1;
    }
}
