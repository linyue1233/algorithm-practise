package amazone;

import java.util.Arrays;

public class MatchsticksSquare {
    // 473
    public boolean makeSquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);
        return allocate(nums, nums.length - 1, new int[4], sum / 4);
    }

    private boolean allocate(int[] nums, int pos, int[] sums, int avg) {
        if (pos <= -1) {
            return sums[0] == avg && sums[1] == avg && sums[2] == avg;
        }
        // set in four index
        int value = nums[pos];
        for (int i = 0; i < 4; ++i) {
            int temp = sums[i] + value;
            if (temp <= avg) {
                sums[i] = temp;
                boolean flag = allocate(nums, pos - 1, sums, avg);
                if (flag) return true;
                sums[i] -= value;
            }
        }
        return false;
    }
}
