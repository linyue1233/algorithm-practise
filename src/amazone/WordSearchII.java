package amazone;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    // 212
    int[] directions = new int[]{-1,0,1,0,-1};
    int m ,n;

    Trie2 trie = new Trie2();

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(String item : words){
            insert(item);
        }
        List<String> ans = new ArrayList<>();

        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                Trie2 tempT = trie;
                dfs(board,visited,ans,i,j,tempT);
            }
        }
        return ans;
    }


    private void dfs(char[][] board,boolean[][] visited,List<String> ans, int x, int y, Trie2 cur){
        if( x < 0 || x >= m || y < 0 || y >=n || visited[x][y]){
            return;
        }
        cur = cur.tree[board[x][y]-'a'];
        if(cur == null){
            return;
        }
        visited[x][y] = true;
        if( cur.isEnd ){
            ans.add(cur.val);
            // avoid repeated word
            cur.isEnd = false;
        }
        dfs(board,visited,ans,x+1,y,cur);
        dfs(board,visited,ans,x-1,y,cur);
        dfs(board,visited,ans,x,y+1,cur);
        dfs(board,visited,ans,x,y-1,cur);
        visited[x][y] = false;
    }

    private void insert(String word){
        Trie2 t = trie;
        for(int i = 0;i<word.length();++i){
            int temp = word.charAt(i) - 'a';
            if( t.tree[temp] == null){
                t.tree[temp] = new Trie2();
            }
            t = t.tree[temp];
        }
        t.isEnd = true;
        t.val = word;
    }
}

class Trie2{
    Trie2[] tree;
    String val;
    Boolean isEnd;
    public Trie2(){
        tree = new Trie2[26];
        isEnd = false;
    }
}



