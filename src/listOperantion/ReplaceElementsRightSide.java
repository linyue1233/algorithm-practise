package listOperantion;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ReplaceElementsRightSide {
    // 1299
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i = arr.length-1;i>=0;--i){
            int temp = arr[i];
            arr[i] = max;
            if(temp > max){
                max = temp;
            }
        }
        return arr;
    }
}
