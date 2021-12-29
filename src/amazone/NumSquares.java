package amazone;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumSquares {
    // 179
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        // if visited, shows that the number appears before and there is no best slovlution
        Set<Integer> visited = new HashSet<>();
        int path = 0;
        queue.offer(0);
        visited.add(0);
        while( !queue.isEmpty()){
            int size = queue.size();
            path++;
            while( size-- >0){
                int cur = queue.poll();
                for(int i = 1;i*i<=n;++i){
                    int sum  = cur + i * i;
                    if( sum == n){
                        return path;
                    }
                    if( sum > n){
                        break;
                    }
                    if( !visited.contains(sum) ){
                        queue.offer(sum);
                        visited.add(sum);
                    }
                }
            }
        }
        return n;
    }
//    public int numSquares(int n) {
//        int[] dp = new int[n+1];
//        dp[1] = 1;
//        for(int i = 1;i<=n;++i){
//            dp[i] = i;
//            for(int j = 1;j*j<=i;++j){
//                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
//            }
//        }
//        return dp[n];
//    }

}
