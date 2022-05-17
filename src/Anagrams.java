import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anagrams {
    public static String test(int n, String[] operations) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append('0');
        }
        int minIndex = 0;
        for (String item : operations) {
            if (item == "L") {
                if (minIndex < n && sb.charAt(minIndex) == '1') {
                    while (minIndex < n && sb.charAt(minIndex) == '1') {
                        minIndex++;
                    }
                }
                if( minIndex <n) sb.setCharAt(minIndex, '1');
            } else {
                int tempIndex = item.charAt(1) - '0';
                sb.setCharAt(tempIndex,'0');
                // update the minIndex
                tempIndex--;
                while(tempIndex >=0 && sb.charAt(tempIndex) == '1'){
                    tempIndex--;
                }
                minIndex = tempIndex > 0 ? tempIndex : item.charAt(1) - '0';
            }
        }
        return sb.toString();
    }

    public static String sticky(String text, char[] sticky){
        Set<Character> set = new HashSet<>();
        for(char c : sticky){
            char temp = Character.toLowerCase(c);
            set.add(temp);
        }
        StringBuilder sb = new StringBuilder();
        int n = text.length();
        int index = 0;
        while( index < n){
            int tempIndex = index;
            char c = Character.toLowerCase(text.charAt(index));
            if(set.contains(c)){
                int mod = 1;
                index++;
                while( index < n && Character.toLowerCase(text.charAt(index)) == c){
                    index++;
                    mod++;
                }
                for(int i = 0;i<mod / 2;++i){
                    sb.append(text.charAt(tempIndex));
                }
            }else{
                index++;
                sb.append(text.charAt(tempIndex));
            }
        }
        return sb.toString();
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;++i){
            int left = i+1, right = n - 1;
            while(left < right){
                long tempSum = nums[i] + nums[left] + nums[right];
                if( Math.abs(tempSum - target) < Math.abs((long) ans - target) ){
                    ans = (int)tempSum;
                }
                if( tempSum == target){
                    return target;
                }else if( tempSum > target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = 1;
        while(true){
            if(nums[left] == nums[right] && left!=right){
                return nums[left];
            }
            left++;
            right = right + 2;
            if( left == right){
                left = 0;
            }
            if(left == n){
                left = 0;
            }
            if(right >= n){
                right = (right-n) % n;
            }
        }
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        // add a special character to store the last word
        paragraph += ".";
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String ans = "";
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        int count = 0;
        for( char c : paragraph.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }else if(sb.length() > 0 ){
                String temp = sb.toString();
                if(  !set.contains(temp)){
                    map.put(temp, map.getOrDefault(temp,0)+1);
                    if( count < map.get(temp) ){
                        ans = temp;
                        count = map.get(temp);
                    }
                }
                sb = new StringBuilder();
            }
        }
        return ans;
    }

    public static int binaryGap(int n) {
        int ans = 0;
        int pre = -1, cur = 0;
        while( n != 0){
            if( (n & 1) == 1){
                if( pre >= 0 ){
                    ans = Math.max(ans,cur - pre);
                }
                pre = cur;
            }
            cur++;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
    }
}
