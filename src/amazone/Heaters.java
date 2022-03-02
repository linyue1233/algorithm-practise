package amazone;

import java.util.Arrays;

public class Heaters {
    // 475
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        int distance = 0;
        int houseIndex = 0, j = 0;
        for(;houseIndex<houses.length;++houseIndex){
            while( j < heaters.length && houses[houseIndex] > heaters[j]){
                j++;
            }
            if( j == 0){
                distance = heaters[0] - houses[houseIndex];
            }else if( j == heaters.length){
                distance = houses[houseIndex] - heaters[j-1];
            }else{
                distance = Math.min(houses[houseIndex] - heaters[j-1], heaters[j] - houses[houseIndex]);
            }
            ans = Math.max(ans,distance);
        }
        return ans;
    }
}
