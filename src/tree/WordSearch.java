package tree;

public class WordSearch {
    // 79
    int[] direction = {-1, 0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean flag = false;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                flag = dfs(board, word, i, j, 0,visited);
                if(flag) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int r, int c, int index,boolean[][] visited) {
        int m = board.length, n = board[0].length;
        if (board[r][c] != word.charAt(index)) return false;
        if(index == word.length() - 1) return true;
        visited[r][c] = true;
        boolean res = false;
        for(int k = 0;k<4;++k){
            int x = r + direction[k], y = c + direction[k+1];
            if(x >=0 && x<m && y>=0 && y<n){
                if(!visited[x][y]){
                    boolean flag = dfs(board, word, x, y, index+1, visited);
                    if(flag){
                        res = true;
                        break;
                    }
;                }
            }
        }
        visited[r][c] = false;
        return res;
    }
}
