package amazone;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    // 238
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        // left means the answer[i]'s left elements product
        int leftProduct = 1, rightProduct = 1;
        for(int i = 0;i<n;++i){
            ans[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }
        for(int i = n-1;i>=0;--i){
            ans[i] = ans[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        return ans;
    }
}
