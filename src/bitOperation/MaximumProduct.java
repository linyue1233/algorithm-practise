package bitOperation;

import java.util.Arrays;

public class MaximumProduct {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] marks = new int[n];
        for(int i = 0;i<n;++i){
            String word = words[i];
            for(int j = 0;j<word.length();j++){
                marks[i] |= 1<<(word.charAt(j) - 'a');
            }
        }

        int maxCount = 0;
        for(int i = 0;i<n;++i){
            for(int j = i+1;j<n;++j){
                if((marks[i] & marks[j]) == 0){
                    maxCount = Math.max(maxCount,words[i].length() * words[j].length());
                }

            }
        }
        return maxCount;
    }
}
