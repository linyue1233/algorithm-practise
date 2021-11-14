package other;

public class IncreasingTriplet {
    // 334
    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        if(nums.length < 3){
            return false;
        }
        for(int n:nums){
            if( n <= left){
                left = n;
            }else if( n <= mid){
                mid = n;
            }else{
                return true;
            }
        }
        return false;
    }
}
