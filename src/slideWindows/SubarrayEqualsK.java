package slideWindows;


import java.util.HashMap;
import java.util.Map;

public class SubarrayEqualsK {

    // 560
    public int subarraySum(int[] nums, int k) {
        int right = 0, len = nums.length;
        int sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        while (right < len) {
            sum += nums[right];
            if(map.containsKey(sum - k)) {
                ans += map.get(sum-k);
            }
            right++;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
