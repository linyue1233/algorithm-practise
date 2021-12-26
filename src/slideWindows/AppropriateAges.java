package slideWindows;

import java.util.Arrays;

public class AppropriateAges {
    // 825
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        if( n<=1){
            return 0;
        }
        int ans = 0;
        Arrays.sort(ages);
        // x will send y when 0.5×ages[x]+7<ages[y]≤ages[x]
        // left-right is the range of y

        int left = 0, right = 0;
        for(int age : ages){
            // the age is age[x]
            if(age < 15){
                continue;
            }
            while(left < n && 0.5*age+7 >= ages[left]  ){
                left++;
            }
            while( right<n && ages[right] <= age){
                right++;
            }
            ans += right-1 - left;
        }
        return ans;
    }
}
