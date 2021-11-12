package other;

public class MinStartValue {
    // 1413
    public int minStartValue(int[] nums) {
        int sum = 0, minValue = Integer.MAX_VALUE;
        for (int i = 0;i<nums.length;++i){
            sum += nums[i];
            minValue = Math.min(sum,minValue);
        }
        if(minValue>=0) return 1;
        return 1-minValue;
    }
}
