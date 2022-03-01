package amazone;

import java.util.Arrays;

public class SellMaxProfit {
    // 1648
    public int maxProfit(int[] inventory, int orders) {
        long ans = 0;
        int mod = 1000000007;
        Arrays.sort(inventory);
        int curIndex = inventory.length-1;
        int curValue = inventory[curIndex];

        while(orders > 0 ){
            while( curIndex >= 0 && inventory[curIndex] == curValue){
                curIndex--;
            }

            // the row length which balls equals
            int rowLength = inventory.length - curIndex -1;
            // avoid out of range
            int nextValue = curIndex<0?0:inventory[curIndex];
            // all numbervalue wait to buy
            int numberValue = rowLength * (curValue - nextValue);

            // buy all
            if( orders >= numberValue  ){
                long tempValue = (long)rowLength * (curValue + nextValue + 1) *(curValue - nextValue)/2;
                ans += tempValue;
            }else{
                // mid is the number after change
                // remainer is the count of last row
                int mid = curValue - orders/rowLength;
                int remainer = orders%rowLength;
                ans += (long)(curValue + mid +1) * (orders/rowLength) /2 * rowLength;
                ans += (long)mid * remainer;
            }
            orders -= numberValue;
            curValue = nextValue;
            ans = ans % mod;
        }
        return (int)ans;
    }
//    int mod = 1000000007;
//    public int maxProfit(int[] inventory, int orders) {
//        Arrays.sort(inventory);
//        int index = inventory.length - 1;
//        long ans = 0;
//        int cnt = 0;
//        // high is the most number of balls
//        // low is the second most number of balls
//        // cnt is the number of high balls
//        // arithmetic sequence sum
//        while(index >= 0){
//            int high = inventory[index], low = 0;
//            while(index >=0 && inventory[index] == high){
//                cnt++;
//                index--;
//            }
//            if( index >= 0){
//                low = inventory[index];
//            }
//
//            if( cnt * (high - low) < orders){
//                orders -= cnt * (high-low);
//                ans += (long)cnt*(high - low)*(high+low+1)/2%mod;
//            }else{
//                // mid is the number after change
//                int mid = high - orders / cnt;
//                orders -= cnt*(high - mid);
//                ans += (long)cnt * (high - mid) *(high + mid + 1) / 2 % mod;
//                ans += (long)orders * mid % mod;
//                return (int)ans%mod;
//            }
//        }
//        return (int)ans % mod;
//    }
}
