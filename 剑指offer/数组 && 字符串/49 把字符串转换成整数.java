//注意考虑溢出和符号位。
public class Solution {
    public int StrToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int res = 0;
        int sign = 1;

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && (chars[i] == '+' || chars[i] == '-')) {
                sign = chars[i] == '+' ? 1 : -1;
                continue;
            }
            int digit = chars[i] - '0';

            if (digit < 0 || digit > 9) {
                return 0;
            }
            // check if total will be overflow after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < res || Integer.MAX_VALUE / 10 == res && digit > Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
        }
        return res * sign;
    }
}