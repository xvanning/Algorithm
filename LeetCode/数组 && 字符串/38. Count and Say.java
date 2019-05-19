// 巧妙解法，记录读数，然后直接把读数放到字符串里面。
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        String before = countAndSay(n - 1);
        for (int i = 0; i < before.length(); i++) {
            char c = before.charAt(i);
            int count = 1;
            while ((i + 1) < before.length() && before.charAt(i + 1) == c) {
                i++;
                count++;
            }
            sb.append(count + "" + c);
        }
        return sb.toString();
    }
}