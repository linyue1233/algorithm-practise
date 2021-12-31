package amazone;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    //37
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();

        backTrack(candidates, target, 0, combine, ans);
        return ans;
    }

    private void backTrack(int[] candidates, int target, int start, List<Integer> tempAns, List<List<Integer>> ans) {
        if (start == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        // not choose the index of now
        backTrack(candidates, target, start + 1, tempAns, ans);
        if (target >= candidates[start]) {
            tempAns.add(candidates[start]);
            backTrack(candidates, target - candidates[start], start, tempAns, ans);
            tempAns.remove(tempAns.size() - 1);
        }
    }

}
