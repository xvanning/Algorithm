class Solution {
    public int titleToNumber(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        int num = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int digit = (int) ((chars[i] - 'A' + 1) * Math.pow(26, num));
            res += digit;
            num++;
        }
        return res;
    }
}