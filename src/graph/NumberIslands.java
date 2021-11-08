package graph;

public class NumberIslands {
    // 200
    int[] directions = {-1,0,1,0,-1};
    public int numIslands(char[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                if(grid[i][j] == '1' && !visited[i][j]){
                    ans++;
                    dfs(visited,grid,i,j,m,n);
                }
            }
        }
        return ans;
    }


    private void dfs(boolean[][] visited, char[][] grid,int x, int y,int m,int n){
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        for(int i = 0;i<4;++i){
            int r = x + directions[i], c = y + directions[i+1];
            if( r >= 0 && r < m && c>=0 && c<n && grid[r][c] == '1'){
                dfs(visited,grid,r,c,m,n);
            }
        }
    }
}
