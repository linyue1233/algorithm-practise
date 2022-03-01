package amazone;

import java.util.Deque;
import java.util.LinkedList;

public class SumSubarrayMins {
    // 907
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        int n = arr.length;
        int mod = 1000000007;
        // used to store the left index which is the least number
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        // monotonic increase
        // loop to find leftIndex
        // store different parts minimum
        for(int i = 0;i<n;++i){
            while( !deque.isEmpty() && arr[deque.peekLast()] > arr[i] ){
                deque.pollLast();
            }
            if( deque.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = deque.peekLast();
            }
            deque.offerLast(i);
        }
        deque.clear();
        for(int i = n- 1;i>=0;i--){
            while(!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]){
                deque.pollLast();
            }
            if(deque.isEmpty()){
                right[i] = n;
            }else{
                right[i] = deque.peekLast();
            }
            deque.offerLast(i);
        }
        for(int i = 0;i<n;++i){
            ans += (long)arr[i] * (i-left[i]) * (right[i]-i);
            ans = ans % mod;
        }
        return (int)ans;
    }
}
