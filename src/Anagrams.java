import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anagrams {
    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> tempAns = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(nums,tempAns,visited);
        return ans;
    }

    private static void backTrack(int[] nums, List<Integer> tempAns, boolean[] visited){
        if(tempAns.size() == nums.length){
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        for(int i = 0;i<visited.length;++i){
            if( !visited[i] ){
                visited[i] = true;
                tempAns.add(nums[i]);
                backTrack(nums,tempAns,visited);
                tempAns.remove(tempAns.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
}
