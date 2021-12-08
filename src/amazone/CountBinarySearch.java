package amazone;

public class CountBinarySearch {
    // 696
    // record list as character
    // s = 00111011  =>{2,3,1,2}
    public int countBinarySubstrings(String s) {
        int pre = 0, curIndex = 0;
        int ans = 0;
        while(curIndex < s.length()){
            char c = s.charAt(curIndex);
            int count = 0;
            while(curIndex < s.length() && c == s.charAt(curIndex)){
                count++;
                curIndex++;
            }
            ans += Math.min(pre,count);
            pre = count;
        }
        return ans;
    }
}
