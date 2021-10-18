package divided;

import java.util.*;

public class BeautifulArray {
    // 932
    private static Map<Integer,int[]> map = new HashMap<>();
    public static   int[] beautifulArray(int N) {
       int[] temp = map.get(N);
       if(temp != null){
           return temp;
       }
       int[] ans = new int[N];
       int index = 0;
       if(N!=1){
           for(int item : beautifulArray((N+1)/2)){
               ans[index++] = item * 2 -1;
           }
           for(int item : beautifulArray(N/2)){
               ans[index++] = item * 2;
           }
       }else{
           ans[0] = 1;
       }
       System.out.println(Arrays.toString(ans));
       map.put(N,ans);
       return ans;
    }

    public static void main(String[] args) {
        beautifulArray(10);
    }
}
