package amazone;

public class WordSearch {
    //79
    int[] directions = new int[]{-1,0,1,0,-1};
    int m ,n;
    public boolean exist(char[][] board, String word) {
        //DFS
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                boolean flag = dfs(board,i,j,visited,0,word);
                if( flag ){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dfs(char[][] board, int x, int y, boolean[][] visited,int index, String word){
        if( board[x][y] != word.charAt(index) ) return false;
        if(index == word.length()-1) return true;
        if( visited[x][y] ) return false;
        visited[x][y] = true;
        for(int i = 0;i<4;++i){
            int r = x + directions[i], c = y + directions[i+1];
            if( r >= 0 && r < m && c >= 0 && c <n && !visited[r][c]){
                boolean ans = dfs(board,r,c,visited,index+1,word);
                if(ans){
                    return true;
                }
            }
        }
        visited[x][y] = false;
        return false;
    }
}
