package twoPointer;

import java.util.Arrays;

public class BoatsSavePeople {
    // 881
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int len = people.length;
        int left = 0, right = len - 1;
        // 1 2 4 5  6
        // 3 3 4 5  5
        while (left <= right) {
            if (left == right) {
                ans++;
                break;
            }
            if (people[left] + people[right] <= limit) {
                ans++;
                right--;
                left++;
            } else {
                ans++;
                right--;
            }
        }
        return ans;
    }


// class Solution {
//     public int numRescueBoats(int[] people, int limit) {
//         int ans = 0;
//         Arrays.sort(people);
//         int sum = 0;
//         int index = 0, len = people.length;
//         int left = 0, right = len-1;
//         // 1 2 4 5  6
//         // 3 3 4 5  5
//         while( left <= right){
//             if( left == right){
//                 left++;
//                 ans++;
//                 break;
//             }
//             if( people[right] == limit || people[left] + people[right] > limit){
//                 ans++;
//                 right--;
//             }else if(people[left] + people[right] == limit){
//                 ans++;
//                 right--;
//                 left++;
//             }else{
//                 sum = people[left++] + people[right--];
//                 while(left <= right){
//                     if(left == right){
//                         if(sum + people[right] > limit){
//                             return ans + 2;
//                         }else{
//                             return ans + 1;
//                         }
//                     }
//                     if(sum + people[right] <= limit){
//                         sum += people[right];
//                         right--;
//                     }else if(sum + people[left] <= limit){
//                         sum += people[left];
//                         left++;
//                     }else{
//                         break;
//                     }
//                 }
//                 sum = 0;
//                 ans++;
//             }
//         }
//         return ans;
//     }
// }
}
