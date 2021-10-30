package matrix;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
    // 73
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> zeroMatrix = new ArrayList<>();
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                if(matrix[i][j] == 0){
                    zeroMatrix.add(new int[]{i,j});
                }
            }
        }
        for(int[] item : zeroMatrix){
            setMatrix(matrix,item[0],item[1],m,n);
        }
    }

    private void setMatrix(int[][] matrix, int x,int y,int m,int n){
        for(int i = 0;i<n;++i){
            matrix[x][i] = 0;
        }

        for(int i = 0;i<m;++i){
            matrix[i][y] = 0;
        }
    }
}
