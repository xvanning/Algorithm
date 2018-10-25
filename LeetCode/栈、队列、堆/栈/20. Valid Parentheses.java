//遇到左括号，就把右括号压入栈。最后进行匹配。
import java.util.Stack;

/**Title: 20. Valid Parentheses
 * Idea: 1. The basic idea is to push the right parentheses ')', ']', or '}' into the stack each time when we encounter left ones.
 *       2. And if a right bracket appears in the string, we need check if the stack is empty and also whether the top element is the same with that right bracket.
 *       3. If not, the string is not a valid one. At last, we also need check if the stack is empty.
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
    return stack.isEmpty();
    }
}