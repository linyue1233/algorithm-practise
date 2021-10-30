package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // 54

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int left =0, right = n-1,top = 0, bottom = m-1;
        int total = m*n;
        while (total >= 1){
            for(int i = left;i<=right && total >= 1;++i){
                ans.add(matrix[top][i]);
                total--;
            }
            top++;
            for(int i = top;i<=bottom && total >= 1;++i){
                ans.add(matrix[i][right]);
                total--;
            }
            right--;
            for(int i = right;i>=left && total >= 1;--i){
                ans.add(matrix[bottom][i]);
                total--;
            }
            bottom--;
            for(int i = bottom;i>=top && total >= 1;--i){
                ans.add(matrix[i][left]);
                total--;
            }
            left++;
        }
        return  ans;
    }
}
