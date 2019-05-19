// 看图说话，左右两边需要看边界最大值。
class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int leftMax = 0; int rightMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax = left[i] = Math.max(leftMax, height[i]);
            rightMax = right[height.length - 1 - i] = Math.max(rightMax, height[height.length - 1 - i]);
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}