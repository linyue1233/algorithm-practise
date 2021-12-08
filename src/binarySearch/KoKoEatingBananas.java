package binarySearch;

public class KoKoEatingBananas {
    // 875
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000, mid ;
        while(left <= right){
            mid = left + (right - left) / 2;
            boolean flag = canEat(piles,h,mid);
            if(flag){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canEat(int[] piles, int h, int value){
        int allTime = 0;
        for(int item:piles){
            allTime += (item - 1) / value + 1;
        }
        return allTime<=h;
    }
}
