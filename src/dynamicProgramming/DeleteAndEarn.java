package dynamicProgramming;

import java.util.*;

public class DeleteAndEarn {
    // 740   test case: 3 4 2


//    public static int deleteAndEarn(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        Arrays.sort(nums);
//        List<Integer> dp = new ArrayList<>();
//
//        // initial
//        dp.add(0);
//        dp.add(nums[0]);
//        int last = nums[0];
//        map.put(nums[0],1);
//
//        for(int i = 1;i<nums.length;++i){
//            int temp = nums[i];
//            map.put(temp, map.getOrDefault(temp,0)+1);
//            if(last != temp){
//                last = temp;
//                dp.add(temp);
//            }
//        }
//
//        last = dp.get(1);
//        dp.set(1, dp.get(1) * map.get(dp.get(1)));
//        for(int i =2 ;i< dp.size();++i){
//            if( dp.get(i) == last + 1){
//                last = dp.get(i);
//                dp.set(i,Math.max( dp.get(i-1), dp.get(i-2) + dp.get(i) * map.get(dp.get(i))));
//            }else{
//                last = dp.get(i);
//                dp.set(i,dp.get(i-1) + dp.get(i) * map.get(dp.get(i)));
//            }
//        }
//        return dp.get(dp.size() - 1);
//    }


    public static int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public static int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6}));
    }
}
