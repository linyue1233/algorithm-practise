package twoPointer;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        int n = arr.length;
        for( int i = 0;i<n;++i){
            if(arr[i] == 0){
                count++;
            }
        }

        for(int i = n-1;i>=0;--i){
            // if this num is 0. count--;
            if( arr[i] == 0) count--;
            // move back, in this loop count means the left part 0
            if( i + count < n ){
                arr[i+count] = arr[i];
                if( arr[i] == 0 && i + count + 1 < n){
                    arr[i+count+1] = arr[i];
                }
            }
        }
    }
}
