
//约瑟夫环，圆圈长度为 n 的解可以看成长度为 n-1 的解再加上报数的长度 m。因为是圆圈，所以最后需要对 n 取余。
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) /* 特殊输入的处理 */
            return -1;
        if (n == 1) /* 递归返回条件 */
            return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
}

// 公式法：非递归
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        if (n == 1) {
            return 0;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}