package other;

public class NonDecreasingArray {
    // 665
    public boolean checkPossibility(int[] nums) {
        int modifyCount = 0;
        int len = nums.length;
        if(len <= 1){
            return true;
        }
        for(int i = 1;i<len && modifyCount < 2;++i){
            if(nums[i] >= nums[i-1]){
                continue;
            }
            modifyCount++;
            if(i-2>=0 && nums[i-2] > nums[i]){
                nums[i] = nums[i-1];
            }
        }
        return modifyCount<=1;
    }
}
