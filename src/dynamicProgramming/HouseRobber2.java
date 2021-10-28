package dynamicProgramming;

public class HouseRobber2 {
    public static int rob(int[] nums) {
        int n = nums.length;
        if( n == 1){
            return nums[0];
        }
        if( n == 2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robHouse(nums,0,n-2),robHouse(nums,1,n-1));
    }

    private static int robHouse(int[] nums, int left, int right) {
        int a = nums[left], b = Math.max(nums[left],nums[left+1]);
        for(int i = left+2;i<=right;++i){
            int temp = b;
            b = Math.max(a+nums[i],b);
            a = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        rob(new int[]{2,3,2});
    }
}
