package amazone;

public class MinimumWindowSub {
    //76
    public String minWindow(String s, String t) {
        int len = s.length(), left = 0, count = 0;
        int minLeft = 0, minSize = len + 1;
        boolean[] flag = new boolean[128];
        int[] store = new int[128];
        for(int i = 0;i<t.length();++i){
            flag[t.charAt(i)] = true;
            store[t.charAt(i)]++;
        }

        for(int i =0;i<len;++i){
            if(flag[s.charAt(i)]){
                if(--store[s.charAt(i)] >= 0){
                    count++;
                }
                while(count == t.length()){
                    if(i-left+1 < minSize){
                        minSize = i-left+1;
                        minLeft = left;
                    }
                    // such as aaaabc ,abc
                    // --store[s.charAt(i)] will decrease the extra char
                    if(flag[s.charAt(left)] && ++store[s.charAt(left)] > 0){
                        count--;
                    }
                    left++;
                }
            }
        }
        return minSize>len?"":s.substring(minLeft,minLeft+minSize);
    }
}
