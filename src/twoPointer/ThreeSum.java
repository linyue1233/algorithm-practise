package twoPointer;

import java.util.*;

public class ThreeSum {
    // 15
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(n <= 2){
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0;i<n;++i){
            if(nums[i] > 0) return ans;
            // De-duplication
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int left = i+1, right = n-1;
            while(left<right){
                if(nums[left] + nums[right] == target){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;
                    right--;
                    while(left<right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(left<right && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(ans));
    }
}
