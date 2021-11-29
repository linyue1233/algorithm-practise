package stack;

import java.util.Stack;

public class SmallestSubsequence {
    // 1081
    public String smallestSubsequence(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[] visited = new boolean[26];
        int[] maxIndex = new int[26];
        char[] questionArr = s.toCharArray();
        for(int i = 0;i<len;++i){
            maxIndex[questionArr[i] - 'a'] = i;
        }

        Stack<Character> ans = new Stack<>();
        for(int i = 0;i<len;++i){
            if(visited[questionArr[i] - 'a']){
                continue;
            }
            visited[questionArr[i] - 'a'] = true;
            while( !ans.isEmpty() && ans.peek() > questionArr[i] && maxIndex[ans.peek() - 'a'] > i){
                visited[ans.pop()-'a'] = false;
            }
            ans.push(questionArr[i]);
        }

        StringBuilder sb = new StringBuilder();

        while (!ans.isEmpty()) {
            sb.insert(0,ans.pop());
        }

        return sb.toString();
    }
}
