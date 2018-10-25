//数组中元素与下一个比它大的元素之间的距离，用栈来存储遍历到的元素下标，如果当前遍历到元素比以栈顶为下标的元素大，则出栈。存储当前下标和栈顶之差
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int curIndex = 0; curIndex < temperatures.length; curIndex ++){
            while (!stack.isEmpty() && temperatures[curIndex] > temperatures[stack.peek()]){
                int preIndex = stack.pop();
                res[preIndex] = curIndex - preIndex;
            }
            stack.push(curIndex);
        }
        return res;
    }
}