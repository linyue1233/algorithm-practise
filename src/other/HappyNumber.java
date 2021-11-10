package other;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HappyNumber {
    // 202
    private int getSquareSum(int n){
        int ans = 0;
        while(n != 0){
            ans += (n%10) * (n%10);
            n = n /10;
        }
        return ans;
    }

    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = getSquareSum(slow);
            fast = getSquareSum(fast);
            fast = getSquareSum(fast);
        }while(slow != fast);

        return slow == 1;

    }

//    public static boolean isHappy(int n) {
//        Map<Integer, Integer> map = new HashMap<>();
//        Deque<Integer> deque = new LinkedList<>();
//        while( n != 0){
//            deque.offer( n% 10);
//            n = n/10;
//        }
//
//        while( !deque.isEmpty() ){
//            int len = deque.size();
//            int ans = 0;
//            for(int i = 0;i<len;++i){
//                int temp = deque.poll();
//                ans += temp * temp;
//            }
//            if( ans == 1){
//                return true;
//            }
//            if( map.containsKey(ans) ){
//                return false;
//            }
//            map.put(ans, 1);
//            while( ans != 0){
//                deque.offer( ans% 10);
//                ans = ans/10;
//            }
//        }
//        return true;
//    }

}
