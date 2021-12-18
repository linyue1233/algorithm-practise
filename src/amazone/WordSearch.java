package amazone;

public class WordSearch {
    //79
    int[] dirctions = {-1,0,1,0,-1};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean flag = false;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                flag = dfs(board, word, i, j, 0,visited);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index, boolean[][] visited){
        if(board[x][y] != word.charAt(index)) return false;
        if(index == word.length() - 1) return true;
        int m = board.length, n = board[0].length;
        visited[x][y] = true;
        boolean ans = false;
        for(int i = 0;i < 4;++i){
            int r = x + dirctions[i], c = y + dirctions[i+1];
            if(r >=0 && r<m && c>=0 && c<n && !visited[r][c]){
                ans = dfs(board,word,r,c,index+1,visited);
                if(ans){
                    break;
                }
            }
        }
        visited[x][y] = false;
        return ans;
    }
}
