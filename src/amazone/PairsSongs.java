package amazone;

public class PairsSongs {
    // 1010
    int mod = 60;
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0, n = time.length;
        int[] store = new int[61];
        for(int i = 0;i<n;++i){
            store[time[i] % mod]++;
        }
        ans += store[0] * (store[0]-1)/2;
        ans += store[30] * (store[30]-1)/2;
        for(int i = 1;i<30;++i){
            ans += store[i] * store[60-i];
        }
        return ans;
    }

//    int mod = 60;
//    public int numPairsDivisibleBy60(int[] time) {
//        int ans = 0, n = time.length;
//        int[] store= new int[60];
//        for(int item : time){
//            item = item %60;
//            if(item !=0){
//                ans += store[60-item];
//            }else{
//                ans += store[0];
//            }
//            store[item]++;
//        }
//        return ans;
//    }

}
