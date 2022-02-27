package amazone;

public class MaximumPositivePro {

    // 1567
    public int getMaxLen(int[] nums) {
        int ans = 0;
        int negaValue = 0,positValue = 0;
        // n == 0 正负数统计清零
        //n>0 正数累加 如果前面有负数 负数也累加
        //n<0 乘后变号 所以正负数累加交换 负数累加 有正数也累加
        //每次非零数都贪最大正数统计长度
        for (int num : nums) {
            if (num > 0) {
                positValue++;
                if (negaValue > 0) {
                    ++negaValue;
                }
                ans = Math.max(ans, positValue);
            } else if (num < 0) {
                int temp = negaValue;
                negaValue = positValue;
                positValue = temp;
                negaValue++;
                if (positValue > 0) {
                    ++positValue;
                }
                ans = Math.max(ans, positValue);
            } else {
                negaValue = 0;
                positValue = 0;
            }
        }
        return ans;
    }
}
