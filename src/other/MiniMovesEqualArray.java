package other;

public class MiniMovesEqualArray {
    // 453
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        // each element increase means that each time you decrease a num with 1
        for (int n : nums) res += n - min;
        return res;
    }
}
