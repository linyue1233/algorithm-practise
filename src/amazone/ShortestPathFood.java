package amazone;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestPathFood {
    // 1730
    int[] directions = new int[]{-1,0,1,0,-1};

    public int getFood(char[][] grid) {
        // bfs
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        int x = 0,y = 0;
        boolean flag = false;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;++j){
                if( grid[i][j] == '*'){
                    x = i;
                    y = j;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{x,y});
        while( !deque.isEmpty()){
            int size = deque.size();
            ans++;
            for(int i = 0;i<size;++i){
                int temp1 = deque.peekFirst()[0];
                int temp2 = deque.peekFirst()[1];
                deque.pollFirst();
                for( int k = 0;k<4;++k){
                    int r = temp1+directions[k], c = temp2+directions[k+1];
                    if( r <0 || r >=m || c <0 || c >= n || grid[r][c] == 'X'){
                        continue;
                    }
                    if( visited[r][c] ){
                        continue;
                    }
                    visited[r][c] = true;
                    if( grid[r][c] == '#'){
                        return ans;
                    }
                    if( grid[r][c] == 'O'){
                        deque.offerLast(new int[]{r,c});
                    }
                }
            }
        }
        return -1;
    }
}
