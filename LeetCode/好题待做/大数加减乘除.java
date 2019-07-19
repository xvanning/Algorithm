public class Solution {
    // 大数相加
    public String add(String a, String b) {
        StringBuilder result = new StringBuilder();
        // 反转字符串
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        int len1 = a.length();
        int len2 = b.length();
        int maxLen = len1 > len2 ? len1 : len2;
        if (maxLen > len1) {
            for (int i = len1; i < maxLen; i++) {
                a += "0";
            }
        } else if (maxLen > len2) {
            for (int i = len2; i < maxLen; i++) {
                b += "0";
            }
        }
        int c = 0; // 进位
        for (int i = 0; i < maxLen; i++) {
            int curNum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + c;
            c = 0;
            if (curNum >= 10) {
                curNum -= 10;
                c = 1;
            }
            result.append(curNum);
        }
        //最高位进位
        if (c > 0) {
            result.append(c);
        }
        return result.reverse().toString();
    }

    // 大数相减
    public String subtraction(String a, String b) {
        StringBuilder result = new StringBuilder();
        //翻转被减数和减数,从低位开始计算
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int len1 = a.length();
        int len2 = b.length();
        int maxLen = len1 > len2 ? len1 : len2;
        if (maxLen > len1) {
            for (int i = len1; i < maxLen; i++) {
                a += "0";
            }
        } else if (maxLen > len2) {
            for (int i = len2; i < maxLen; i++) {
                b += "0";
            }
        }
        int c = 0; // 借位;
        for (int i = 0; i < maxLen; i++) {
            int curNum = (a.charAt(i) - '0') - (b.charAt(i) - '0') - c;
            c = 0; // 借位清零
            if (curNum < 0) {
                curNum += 10;
                c = 1;
            }
            result.append(curNum);
        }
        // 去除字符串前面多余的0
        String s = result.reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                continue;
            }
            s = s.substring(i);
            break;
        }
        return s;
    }

    // 大数相乘
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int curMul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j; int p2 = i + j + 1;
                int curSum = curMul + res[p2];

                res[p1] += curSum / 10;
                res[p2] = curSum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}