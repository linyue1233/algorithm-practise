package dynamicProgramming;

public class BestTimeSellStock {
    // 121
    public int maxProfit(int[] prices) {
        int sell = 0, buy = Integer.MAX_VALUE;
        for (int i= 0;i<prices.length;++i){
            buy = Math.min(buy,prices[i]);
            sell = Math.max(sell,prices[i] - buy );
        }
        return sell;
    }
}
