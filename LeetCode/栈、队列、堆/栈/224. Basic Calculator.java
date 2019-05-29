import java.util.Stack;

/**
 * 我们需要一个栈来辅助计算，用个变量sign来表示当前的符号，
 * 我们遍历给定的字符串s，
 * 如果遇到了数字，由于可能是个多位数，所以我们要用while循环把之后的数字都读进来，
 * 然后用sign*num来更新结果res；
 * 如果遇到了加号，则sign赋为1，如果遇到了负号，则赋为-1；
 * 如果遇到了左括号，则把当前结果res和符号sign压入栈，res重置为0，sign重置为1；
 * 如果遇到了右括号，结果res乘以栈顶的符号，栈顶元素出栈，结果res加上栈顶的数字，栈顶元素出栈。
 */
class Solution {
    public int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        int len = s.length();
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int cur = s.charAt(i);
            if (Character.isDigit(cur)) {  // 注意这里与第二题不同
                int num = cur - '0';
                while ((i + 1) < len && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += num * sign;
            } else if (cur == '+') {
                sign = 1;
            } else if (cur == '-') {
                sign = -1;
            } else if (cur == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (cur == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}