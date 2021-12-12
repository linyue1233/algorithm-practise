package matrix;

public class MaxSkyline {
    // 807
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[][] maxSky = new int[2][n];
        for(int i = 0;i<n;++i){
            for(int j = 0;j<n;++j){
                maxSky[1][i] = Math.max(maxSky[1][i],grid[i][j]);
                maxSky[0][j] = Math.max(maxSky[0][j],grid[i][j]);
            }
        }
        int ans = 0;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<n;++j){
                ans += Math.min(maxSky[1][j],maxSky[0][i]) - grid[i][j];
            }
        }
        System.out.println(maxSky);
        return ans;
    }

    public static void main(String[] args) {
        maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}});
    }
}
