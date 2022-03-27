package amazone;

import java.util.Arrays;

public class ThreeSumClosest {
    // 16
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 1000000;
        for(int i = 0;i<n;++i){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i+1, right = n - 1;
            while(left < right){
                int tempSum = nums[i] + nums[left] + nums[right];
                if( Math.abs(tempSum - target) < Math.abs( ans - target) ){
                    ans = tempSum;
                }
                if( tempSum == target){
                    return target;
                }else if( tempSum > target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }
}
