package amazone;

public class FlipStringMin {
    //926
    public int minFlipsMonoIncr(String s) {
        int allZero = 0, len = s.length();
        for(int i = 0;i<len;++i){
            if(s.charAt(i) == '0'){
                allZero++;
            }
        }
        int allOne = len - allZero;
        int minSum = Integer.MAX_VALUE;
        int leftOne = 0;
        for(int i = 0;i<len;++i){
            char c = s.charAt(i);
            if( c == '1'){
                // store the sum of 1 before the index and 0 after the index
                int temp = leftOne +( (len - i - 1) - (allOne - leftOne-1) );
                // find the fewest sum of index 01
                if(temp < minSum){
                    minSum = temp;
                }
                leftOne++;
            }else{
                int temp = leftOne +( (len - i - 1) - (allOne - leftOne) );
                if(temp < minSum){
                    minSum = temp;
                }
            }
        }
        return minSum;
    }
}
