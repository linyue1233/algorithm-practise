package interval;

import java.util.*;

public class MaxSumOfThreeSubarrays {

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        // store pre sum of k
        int[] sum = new int[len - k + 1];
        for (int i = 0; i < k; ++i) {
            sum[0] += nums[i];
        }
        for (int i = 1; i <= len - k; ++i) {
            sum[i] = sum[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        int[] left = new int[sum.length];
        int[] right = new int[sum.length];
        right[sum.length-1] = sum.length-1;
        // find maxIndex from left and right
        for (int i = 1; i < sum.length; ++i) {
            left[i] = sum[i] > sum[left[i - 1]] ? i : left[i - 1];
        }
        for (int i = sum.length - 2; i >= 0; --i) {
            right[i] = sum[i] > sum[right[i + 1]] ? i : right[i + 1];
        }
        // find the mid intervals
        int maxSum = 0;
        int[] ans = new int[3];
        for (int i = k; i <= sum.length - k; ++i) {
            int temp = sum[left[i - k]] + sum[i] + sum[right[i + k]];
            if (maxSum < temp) {
                ans = new int[]{left[i-k], i, right[i + k]};
                maxSum = temp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[]{9,8,7,6,2,2,2,2}, 2)));
    }
}
