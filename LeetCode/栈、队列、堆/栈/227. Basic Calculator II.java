/**
 * ，由于存在运算优先级，我们采取的措施是使用一个栈保存数字，
 * 如果该数字之前的符号是加或减，那么把当前数字压入栈中，
 * 注意如果是减号，则加入当前数字的相反数，因为减法相当于加上一个相反数。
 * 如果之前的符号是乘或除，那么从栈顶取出一个数字和当前数字进行乘或除的运算，
 * 再把结果压入栈中，那么完成一遍遍历后，所有的乘或除都运算完了，
 * 再把栈中所有的数字都加起来就是最终结果了
 */
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        int len = s.length();
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) { // 注意这里与第一题不同
                num = num * 10 + cur - '0';
            }
            if (!Character.isDigit(cur) && cur != ' ' || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = cur;
            }
        }
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}