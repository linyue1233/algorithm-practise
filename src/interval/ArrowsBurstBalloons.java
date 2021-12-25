package interval;

import java.util.Arrays;

public class ArrowsBurstBalloons {
    // 452
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] < b[1] ? -1 : 1);
        int ans = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; ++i) {
            if (pre < points[i][0]) {
                ans++;
                pre = points[i][1];
            }
        }
        return ans;

    }
}
