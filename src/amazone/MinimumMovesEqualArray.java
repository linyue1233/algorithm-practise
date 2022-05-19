package amazone;

import java.util.Arrays;

public class MinimumMovesEqualArray {
    // 462
    public int minMoves2(int[] nums) {
        // find median
        Arrays.sort(nums);
        int n = nums.length;
        int mid = nums[n / 2];
        int ans = 0;
        for (int item : nums) {
            ans += Math.abs(item - mid);
        }
        return ans;
    }
}
