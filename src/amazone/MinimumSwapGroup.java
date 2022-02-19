package amazone;

public class MinimumSwapGroup {
    // 1151
    public int minSwaps(int[] data) {
        int lenOne = 0;
        for(int item : data){
            if(item == 1){
                lenOne++;
            }
        }
        int windowOne = 0;
        for(int i = 0;i<lenOne;++i){
            if(data[i] == 1){
                windowOne++;
            }
        }
        int ans = lenOne - windowOne;
        for(int i = lenOne;i<data.length;++i){
            if(data[i-lenOne]==1){
                windowOne--;
            }
            if( data[i] == 1){
                windowOne++;
            }
            ans = Math.min(ans, lenOne - windowOne);
        }
        return ans;
    }
}
