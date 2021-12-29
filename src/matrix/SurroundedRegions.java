package matrix;

public class SurroundedRegions {
    // 130
    int[] directions = new int[]{-1,0,1,0,-1};
    int m;
    int n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        // from four board
        for(int i = 0;i<m;++i){
            dfs(board,i,0,visited);
            dfs(board,i,n-1,visited);
        }
        for(int i = 0;i<n;++i){
            dfs(board,0,i,visited);
            dfs(board,m-1,i,visited);
        }

        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                if( !visited[i][j] ){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y,boolean[][] visited){
        if( visited[x][y] || board[x][y] =='X'){
            return;
        }
        visited[x][y] = true;
        for(int i = 0;i<4;++i){
            int r = x + directions[i], c = y + directions[i+1];
            if( r>=0 && r<m && c >=0 && c<n && !visited[r][c] && board[r][c] == 'O'){
                dfs(board,r,c,visited);
            }
        }
    }
}
