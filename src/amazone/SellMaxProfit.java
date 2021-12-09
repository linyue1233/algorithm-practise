package amazone;

import java.util.Arrays;

public class SellMaxProfit {
    // 1648
    public static int maxProfit(int[] inventory, int orders) {
        // 很明显，应该先卖个数最多的球
        int mod = 1000000007;
        Arrays.sort(inventory);
        int curIndex = inventory.length-1;
        int curValue = inventory[curIndex];

        long profit = 0;
        while(orders>0) {
            while(curIndex>=0 && inventory[curIndex]==curValue) {
                curIndex--;
            }
            // 令最少的为0球，防止越界
            int nextValue = curIndex<0?0:inventory[curIndex];
            // 目前球相等的个数
            int numSameColor = inventory.length-1-curIndex;
            // 将要买的球的个数
            int nums = (curValue-nextValue)*numSameColor;

            if(orders>nums) {
                // 如果还可以买的个数较多，就直接全买
                profit += (long)(curValue + nextValue + 1) * (curValue - nextValue) / 2 * numSameColor;
            } else {
                // 不能全买
                // mid is the number after change
                int mid = curValue - orders/numSameColor;
                int remainder = orders%numSameColor;
                profit += (long)(curValue + mid+ 1) * (orders/numSameColor) / 2 * numSameColor;
                profit += (long)mid * remainder;
            }
            orders -= nums;
            profit = profit % mod;
            curValue = nextValue;
        }
        return (int)profit;
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
