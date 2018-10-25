//用栈，注意先后顺序。看重构的代码。注意switch用法
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    private static final Set<String> OPERATORS =
            new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(eval(x, y, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int eval(int x, int y, String operator) {
        switch (operator) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            default: return x / y;
        }
    }
}


//基本思路

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        int a,b;
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(String s: tokens){
            if ("+".equals(s)){
                b = stack.pop();
                a = stack.pop();
                res = a + b;
                stack.push(res);
            } else if ("-".equals(s)){
                b = stack.pop();
                a = stack.pop();
                res = a - b;
                stack.push(res);
            } else if ("*".equals(s)){
                b = stack.pop();
                a = stack.pop();
                res = a * b;
                stack.push(res);
            } else if ("/".equals(s)){
                b = stack.pop();
                a = stack.pop();
                res = a / b;
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}

