package binarySearch;

public class SearchRotatedSortedArray {
    // 33
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int mid;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] == nums[mid]){
                left++;
            }else if(nums[mid] <=nums[right] ){
                if(target > nums[mid] && nums[right] >= target){
                    left = mid + 1;
                }else{
                    right = mid-1;
                }
            }else{
                if(target >= nums[left] && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}
