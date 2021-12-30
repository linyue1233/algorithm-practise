package amazone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempAns = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backTrack(nums,tempAns,visited,ans);
        return ans;
    }

    private void backTrack(int[] nums, List<Integer> tempAns, boolean[] visited,List<List<Integer>> ans){
        if(tempAns.size() == nums.length){
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        for(int i = 0;i<visited.length;++i){
            // 因为backtrack调用完以后，vis[i]被设为0，也就是说在下次循环开始，vis[i-1]为0代表它已经被访问过了。
            if( i!=0 && nums[i-1] == nums[i] && !visited[i-1]){
                continue;
            }
            if( !visited[i] ){
                visited[i] = true;
                tempAns.add(nums[i]);
                backTrack(nums,tempAns,visited,ans);
                tempAns.remove(tempAns.size()-1);
                visited[i] = false;
            }
        }
    }
}
