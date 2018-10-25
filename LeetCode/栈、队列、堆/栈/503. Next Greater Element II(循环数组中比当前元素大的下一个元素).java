//与739题一样。不过循环数组中比当前元素大的下一个元素，与上一题一样。不过是循环数组，并且存储是的元素的大小。

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int curIndex = 0; curIndex < nums.length * 2; curIndex++) {
            int num = nums[curIndex % nums.length];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            if (curIndex < nums.length) {
                stack.push(curIndex);
            }
        }
        return res;
    }
}