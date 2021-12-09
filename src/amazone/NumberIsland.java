package amazone;

public class NumberIsland {
    // 200
    //dfs
    int[] directions = {-1,0,1,0,-1};
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid,i,j,visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int x ,int y,boolean[][] visited){
        if(visited[x][y]) return;
        visited[x][y] = true;
        for(int i = 0;i<4;++i){
            int r = x + directions[i], c = y + directions[i+1];
            if( r>=0 && r < grid.length && c>=0 && c<grid[0].length && grid[r][c] == '1'){
                dfs(grid,r,c,visited);
            }
        }
    }
}
