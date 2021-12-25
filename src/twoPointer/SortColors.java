package twoPointer;

public class SortColors {
    // 75
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        for(int i = 0;i<=right;++i){
            while( i<= right && nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
