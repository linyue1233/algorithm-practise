package amazone;

import java.util.PriorityQueue;

public class FindKthLargest {
    // 215
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->a-b);
        pq.offer(nums[0]);
        for(int i = 1;i<nums.length;++i){
            if( nums[i] > pq.peek()){
                if(pq.size() >= k){
                    pq.poll();
                }
                pq.offer(nums[i]);
            }else if( pq.size() < k){
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}

