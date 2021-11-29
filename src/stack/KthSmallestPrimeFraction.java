package stack;

import java.util.*;

public class KthSmallestPrimeFraction {
    // 786
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        List<int[]> frac = new ArrayList<int[]>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                frac.add(new int[]{arr[i], arr[j]});
            }
        }
        frac.sort((x, y) -> x[0] * y[1] - y[0] * x[1]);
        return frac.get(k - 1);
    }
}
