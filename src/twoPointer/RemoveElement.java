package twoPointer;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 27
        int low= 0,fast = 0;
        while(fast < nums.length){
            if( nums[fast] != val){
                nums[low++] = nums[fast++];
            }else{
                fast++;
            }
        }
        return low;
    }
}
