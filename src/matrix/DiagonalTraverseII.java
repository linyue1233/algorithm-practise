package matrix;

import java.util.*;

public class DiagonalTraverseII {
    // 1424
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int len  =0;
        Map<Integer,List<Integer>> map = new LinkedHashMap<>();
        for(int i = 0;i<nums.size();++i){
            len += nums.get(i).size();
            for(int j=0;j<nums.get(i).size();++j){
                if( map.containsKey(i+j) ){
                    map.get(i+j).add(nums.get(i).get(j));
                }else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums.get(i).get(j));
                    map.put(i+j,temp);
                }
            }
        }

        int[] ans = new int[len];
        int count = 0;
        for(int key:map.keySet()){
            List<Integer> temp = map.get(key);
            for( int j =temp.size()-1;j>=0;--j){
                ans[count++] = temp.get(j);
            }
        }
        return ans;
    }
}
