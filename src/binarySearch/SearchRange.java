package binarySearch;

public class SearchRange {
    //34
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int leftIndex = findLeftIndex(nums, target);
        int rightIndex = findRightIndex(nums, target) - 1;
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target) {
            return new int[]{leftIndex, rightIndex};
        }
        return new int[]{-1, -1};
    }


    private int findLeftIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        // the nums[right] always be the one left of the leftest target
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int findRightIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        // the nums[right] always be <= target
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
