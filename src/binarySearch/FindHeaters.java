package binarySearch;

import java.util.Arrays;

public class FindHeaters {
    // 472
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, j = 0;
        int distance = 0;
        // for eaach house, it uses the pre-heater or late-heaater
        // compare the two distances
        for(i = 0;i<houses.length;++i){
            while(j<heaters.length && heaters[j] < houses[i]){
                j++;
            }
            if( j == 0){
                // [1,2,3] 4
                distance = heaters[0] - houses[i];
            }else if( j == heaters.length){
                distance = houses[i] - heaters[j-1];
            }else{
                distance = Math.min(houses[i] - heaters[j-1], heaters[j] - houses[i]);
            }
            ans = Math.max(ans,distance);
        }
        return ans;
    }
}
