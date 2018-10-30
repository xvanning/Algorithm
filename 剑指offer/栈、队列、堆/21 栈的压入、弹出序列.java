import java.util.Stack;
//遍历pushA。不断入栈，直到popA的当前数字和栈顶相同，则不断出栈。 最后检查栈是否为空。
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length != popA.length || pushA == null || popA == null){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for(int i = 0; i < pushA.length; i ++){
            stack.push(pushA[i]);
            while(!(stack.isEmpty()) && (stack.peek() == popA[popIndex])){ //注意要判定栈非空。
                popIndex ++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}