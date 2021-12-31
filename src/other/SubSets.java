package other;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    // 78
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans,new ArrayList<>(), 0, nums);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, List<Integer> tempAns,int start, int[] nums){
        ans.add(new ArrayList<>(tempAns));
        if(start == nums.length){
            return;
        }
        for(int i = start;i<nums.length;++i){
            tempAns.add(nums[i]);
            backTrack(ans,tempAns, i+1, nums);
            tempAns.remove(tempAns.size()-1);
        }
    }
}
