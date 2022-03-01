package amazone;

public class RangeAddition {
    // 370
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        // difference method
        for(int[] update : updates){
            int t1 = update[0];
            int t2 = update[1];
            ans[t1] += update[2];
            if( t2 != length - 1 ){
                ans[t2+1] -= update[2];
            }
        }
        for( int i = 1;i<length;++i){
            ans[i] += ans[i-1];
        }
        return ans;
    }
}
