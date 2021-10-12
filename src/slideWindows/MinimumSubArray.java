package slideWindows;

public class MinimumSubArray {
    // 209
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = 0, minLen = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
            if (sum >= target) {
                minLen = Math.min(i - left + 1, minLen);
                sum = sum - nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
