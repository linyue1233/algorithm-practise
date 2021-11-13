package matrix;

public class DiagonalTraverse {
    // 498
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int i = 0, j = 0,count = 0;
        int[] ans = new int[m*n];
        // flag 1 down
        int flag = 0;
        while( count < m*n){
            ans[count++] = mat[i][j];
            if(flag == 1){
                if( j == 0 && i<m-1){
                    flag = 0;
                    i++;
                }else if(i == m-1){
                    j++;
                    flag = 0;
                }else{
                    j--;
                    i++;
                }
            }else{
                if( i == 0 && j < n-1){
                    j++;
                    flag = 1;
                }else if( j== n-1 ){
                    i++;
                    flag = 1;
                }else{
                    i--;
                    j++;
                }
            }
        }
        return ans;
    }
}
