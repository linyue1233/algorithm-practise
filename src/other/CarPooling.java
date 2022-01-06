package other;

import java.util.Arrays;

public class CarPooling {
    // 1094
    public static boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a, b)->a[1] - b[1]);
        int[] passenger = new int[10001];
        for(int i = 0;i<trips.length;++i){
            int from = trips[i][1];
            int toDis = trips[i][2];
            int numPerson = trips[i][0];
            for(int j = from;j<toDis;j++){
                passenger[j] += numPerson;
                if(passenger[j] > capacity){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{{2,1,5},{3,5,7}},3));
    }
}
