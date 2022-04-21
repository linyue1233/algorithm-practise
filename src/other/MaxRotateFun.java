package other;

public class MaxRotateFun {
    // 396
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int ans = 0, sum = 0, pre = 0;
        // F(i) - F(i-1) = sum - n * nums[n-i];
        // F(i) = sum - n * nums[n-i] + F(i-1);
        for(int i = 0;i<n;++i){
            sum += nums[i];
            pre += i * nums[i];
        }
        ans = pre;
        for(int size =1 ;size<n;++size){
            pre = sum - n * nums[n-size] + pre;
            ans = Math.max(ans,pre);
        }
        return ans;
    }
}
