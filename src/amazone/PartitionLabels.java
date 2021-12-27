package amazone;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    // 763
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        // record the last letter
        int[] lastLetter = new int[26];
        int len = s.length();
        for(int i = 0;i<len;++i){
            lastLetter[s.charAt(i) - 'a'] = i;
        }
        // the first index of a array
        int firstIndex = 0;
        while(firstIndex < len){
            int lastIndex = firstIndex;
            for(int i = firstIndex;i<len && i<=lastIndex;++i){
                int tempIndex = lastLetter[s.charAt(i) - 'a'];
                if(tempIndex > lastIndex){
                    lastIndex = tempIndex;
                }
            }
            ans.add(lastIndex-firstIndex+1);
            firstIndex = lastIndex + 1;
        }
        return ans;
    }
}
