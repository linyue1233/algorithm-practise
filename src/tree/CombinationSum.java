package tree;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // 39
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        // index represent candidates
        dfs(candidates, target, combine, 0, ans);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<Integer> combine, int index, List<List<Integer>> ans) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        // not choose the index of num
        dfs(candidates, target, combine, index + 1, ans);
        // choose
        if (target >= candidates[index]) {
            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], combine, index, ans);
            // remove the last index
            combine.remove(combine.size() - 1);
        }
    }
}
