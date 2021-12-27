package binarySearch;

public class SingleElementSorted {
    // 540
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // make sure the mid index is even
            // the binary array has odd number
            int mid = left + (right - left) / 4 * 2;
            if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid - 2;
            }
        }
        return nums[left];

    }
}
