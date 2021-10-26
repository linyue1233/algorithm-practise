package bitOperation;

public class MissingNumber {
    // 268
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        int ans = 0;
        for(int i = 0;i<=n;++i){
            sum += i;
        }
        for (int num : nums) {
            ans += num;
        }
        return sum-ans;
    }
}
