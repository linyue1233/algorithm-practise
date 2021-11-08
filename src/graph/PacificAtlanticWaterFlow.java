package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    // 417
    int[] directions = {-1,0,1,0,-1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacficAns = new boolean[m][n];
        boolean[][] atlanticAns = new boolean[m][n];

        // from four edges to search
        for(int i = 0;i<m;++i){
            dfs(pacficAns,m,n,heights,i,0);
            dfs(atlanticAns,m,n,heights,i,n-1);
        }
        for(int i = 0;i<n;++i){
            dfs(pacficAns,m,n,heights,0,i);
            dfs(atlanticAns,m,n,heights,m-1,i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                if( pacficAns[i][j] && atlanticAns[i][j]){
                    ans.add( new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return ans;
    }

    private void dfs(boolean[][] islands, int m, int n, int[][] heights,int x,int y){
        if(islands[x][y]){
            return;
        }
        islands[x][y] = true;
        for(int i = 0;i<4;++i){
            int r = x + directions[i], c = y + directions[i+1];
            if( r >= 0 && r < m && c>=0 && c<n && heights[r][c] >= heights[x][y]){
                dfs(islands,m,n,heights,r,c);
            }
        }
    }
}
