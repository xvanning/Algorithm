class Solution {
    public int calculate(String s) {
        int n = s.length(), num = 0, curRes = 0, res = 0;
        char sign = '+';
        for (int i = 0; i < n; ++i) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                num = num * 10 + cur - '0';
            } else if (cur == '(') {
                int j = i, cnt = 0;
                while (i < n) {
                    if (s.charAt(i) == '(') ++cnt;
                    if (s.charAt(i) == ')') --cnt;
                    if (cnt == 0) break;
                    i++;
                }
                num = calculate(s.substring(j + 1, i));
            }
            if (cur == '+' || cur == '-' || cur == '*' || cur == '/' || i == n - 1) {
                switch (sign) {
                    case '+':
                        curRes += num;
                        break;
                    case '-':
                        curRes -= num;
                        break;
                    case '*':
                        curRes *= num;
                        break;
                    case '/':
                        curRes /= num;
                        break;
                }
                if (cur == '+' || cur == '-' || i == n - 1) {
                    res += curRes;
                    curRes = 0;
                }
                sign = cur;
                num = 0;
            }
        }
        return res;
    }
};