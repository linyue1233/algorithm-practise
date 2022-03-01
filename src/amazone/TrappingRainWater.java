package amazone;

public class TrappingRainWater {
    // 42
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int ans = 0;
        // two pointer
        int leftIndex = 0, rightIndex = height.length - 1;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        while (leftIndex <= rightIndex) {
            leftMax = Math.max(height[leftIndex], leftMax);
            rightMax = Math.max(height[rightIndex], rightMax);
            if (leftMax > rightMax) {
                ans += rightMax - height[rightIndex--];
            } else {
                ans += leftMax - height[leftIndex++];
            }
        }
        return ans;

    }
}
