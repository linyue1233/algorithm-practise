package dynamicProgramming;

public class BestTimeSellStockK {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n<2) return 0;

        if(k>=n){
            return buyAlldays(prices);
        }

        int[] sell = new int[k+1];
        int[] buy = new int[k+1];
        for(int i = 0;i<=k;++i){
            buy[i] = Integer.MIN_VALUE;
        }

        for(int i = 0;i<prices.length;++i){
            for(int j = 1;j<=k;++j){
                buy[j] = Math.max(buy[j],sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j],buy[j] + prices[i]);
            }
        }
        return sell[k];
    }

    int buyAlldays(int[] prices){
        int ans = 0;
        for(int i = 1;i<prices.length;++i){
            if(prices[i] > prices[i-1]){
                ans += prices[i] = prices[i-1];
            }
        }
        return ans;
    }
}
