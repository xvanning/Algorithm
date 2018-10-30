import java.util.Stack;
//代码最简洁版。注意pop的时候要两个栈顶相同的时候，pop出minStack中的元素；
public class Solution {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if (minStack.isEmpty() || min() >= node) {
            minStack.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if (top() == min()) {
            minStack.pop();
        }
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}