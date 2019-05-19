import java.util.ArrayList;
import java.util.List;

// 简单递归。注意递归的时候左括号剩余个数不能大于右括号剩余个数
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, n, "", res);
        return res;
    }

    private void helper(int left, int right, String s, List<String> res) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        helper(left - 1, right, s + "(", res);
        helper(left, right - 1, s + ")", res);

    }
}