package matrix;

import java.util.Arrays;

public class ColorBorder {
    //1043
    int[] directions = {-1,0,1,0,-1};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int originalValue = grid[row][col];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid,row,col,color,originalValue,visited);
        return grid;
    }

    private void dfs(int[][] grid, int x , int y, int color,int value,boolean[][] visited){
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        for(int i = 0;i<4;++i){
            int r = x + directions[i], c = y + directions[i+1];
            if(r>=0 && r<grid.length && c>=0 && c< grid[0].length && grid[r][c] == value){
                dfs(grid,r,c,color,value,visited);
            }else{
                if(r>=0 && r<grid.length && c>=0 && c< grid[0].length && visited[r][c]){
                    continue;
                }else {
                    grid[x][y] = color;
                }

            }
        }
    }
}
