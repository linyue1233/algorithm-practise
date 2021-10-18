import java.util.*;
import java.util.stream.Collectors;

public class tikTok {

    // 134
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1, end = 0;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end++;
            } else {
                start--;
                sum += gas[start] - cost[start];
            }
        }
        return sum >= 0 ? start : -1;
    }

    // 696
    public static int countBinarySubstrings(String s) {
        int pre = 0, cur = 0;
        int ans = 0;
        while(cur < s.length()){
            char c = s.charAt(cur);
            int count = 0;
            while( cur < s.length() && c == s.charAt(cur)){
                cur++;
                count++;
            }
            ans += Math.min(pre,count);
            pre = count;
        }
        return ans;
    }

    // 1048
    public static int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        for(String word:words){
            int best = 0;
            for(int i = 0; i < word.length(); i++){
                String prev = word.substring(0, i) + word.substring(i+1);
                best = Math.max(dp.getOrDefault(prev, 0) + 1, best);
            }
            dp.put(word, best);
            res = Math.max(best, res);
        }
        return res;
    }

    //changed from 905
    public static int minimumStepDivided(int[] nums){
        int left = 0, right = nums.length-1;
        int ans = 0;
        while(left < right){
           while(left < right && nums[left] % 2 == 0){
               left++;
           }
           while(left < right && nums[right] % 2 == 1){
               right--;
           }
           if(left < right){
               int temp = nums[right];
               nums[right] = nums[left];
               nums[left] = temp;
               ans++;
           }else {
               break;
           }
        }
        return ans;
    }
}

