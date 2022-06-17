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
                if (minIndex < n) sb.setCharAt(minIndex, '1');
            } else {
                int tempIndex = item.charAt(1) - '0';
                sb.setCharAt(tempIndex, '0');
                // update the minIndex
                tempIndex--;
                while (tempIndex >= 0 && sb.charAt(tempIndex) == '1') {
                    tempIndex--;
                }
                minIndex = tempIndex > 0 ? tempIndex : item.charAt(1) - '0';
            }
        }
        return sb.toString();
    }

    public static String sticky(String text, char[] sticky) {
        Set<Character> set = new HashSet<>();
        for (char c : sticky) {
            char temp = Character.toLowerCase(c);
            set.add(temp);
        }
        StringBuilder sb = new StringBuilder();
        int n = text.length();
        int index = 0;
        while (index < n) {
            int tempIndex = index;
            char c = Character.toLowerCase(text.charAt(index));
            if (set.contains(c)) {
                int mod = 1;
                index++;
                while (index < n && Character.toLowerCase(text.charAt(index)) == c) {
                    index++;
                    mod++;
                }
                for (int i = 0; i < mod / 2; ++i) {
                    sb.append(text.charAt(tempIndex));
                }
            } else {
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
        for (int i = 0; i < n; ++i) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                long tempSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(tempSum - target) < Math.abs((long) ans - target)) {
                    ans = (int) tempSum;
                }
                if (tempSum == target) {
                    return target;
                } else if (tempSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = 1;
        while (true) {
            if (nums[left] == nums[right] && left != right) {
                return nums[left];
            }
            left++;
            right = right + 2;
            if (left == right) {
                left = 0;
            }
            if (left == n) {
                left = 0;
            }
            if (right >= n) {
                right = (right - n) % n;
            }
        }
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        // add a special character to store the last word
        paragraph += ".";
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String ans = "";
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        int count = 0;
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (sb.length() > 0) {
                String temp = sb.toString();
                if (!set.contains(temp)) {
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                    if (count < map.get(temp)) {
                        ans = temp;
                        count = map.get(temp);
                    }
                }
                sb = new StringBuilder();
            }
        }
        return ans;
    }

    public static int[]  binaryGap(int n, int m, int[] a) {
        // write code here
        int left = m - 1, right = n - 1;
        while (m > 0) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            m--;
            left--;
            right--;
        }
        return a;
    }

    public static String test(String str){
        int count = 0;
        int index = 0;
        for(char i : str.toCharArray()){
            index++;
            if( Character.isDigit(i)){
                count = count * 10 + (i-'0');
            }else{
                break;
            }
        }
        //现在知道了重复次数
        //index 用来记录下标，
        StringBuilder sb = new StringBuilder();
//        for(;index<str.length()-1;++index){
//            sb.append(str.charAt(index));
//        }
        String tempStr = str.substring(index,str.length()-1);
        String s = tempStr.repeat(count);
        return s;
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int mid = 0, left = 0, right = arr.length-1;
        while(left <= right){
            mid = left + (right - left) / 2;
            if( arr[mid] == x){
                break;
            }else if(arr[mid] > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if( arr[mid] != x){
            mid = left;
        }else{
            ans.add(arr[mid]);
            left = mid+1;
            right = mid-1;
            k--;
        }
        // right becomes the left part
        while( k > 0 && right >=0 && left < arr.length){
            if(Math.abs(arr[right]-x) <= Math.abs(arr[left] - x)){
                ans.add(0,arr[right--]);
            }else{
                ans.add(arr[left++]);
            }
            k--;
        }
        if( k == 0){
            return ans;
        }else{
            if(right<0){
                while(k>0){
                    k--;
                    ans.add(arr[left++]);
                }
            }else{
                while(k>0){
                    k--;
                    ans.add(0,arr[right--]);
                }
            }
        }
        return ans;
    }

    public static int findPairs(int[] nums, int k) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        Set<int[]> set = new HashSet<>();
        for(int i = 0;i<nums.length;++i){
            int val1 = nums[i] - k;
            int val2 = nums[i] + k;
            if( map.getOrDefault(val1,0) != 0){
                if( val1 > nums[i]){
                    set.add(new int[]{nums[i],val1});
                }else{
                    set.add(new int[]{val1,nums[i]});
                }
            }
            if( map.getOrDefault(val2,0) != 0){
                if( val2 > nums[i]){
                    set.add(new int[]{nums[i],val2});
                }else{
                    set.add(new int[]{val2,nums[i]});
                }
            }
            map.put(nums[i],1);
        }
        return set.size();
    }


    public static void main(String[] args) {
//        System.out.println();
    }
}
