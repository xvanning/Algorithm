class Solution {
    public int reverse(int x) {
        int num = 0;
        int a = 0; //余数
        while (x != 0) {
            a = x % 10;
            x = x / 10;
            if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && a > Integer.MAX_VALUE % 10){
                return 0;
            }
            if (num < Integer.MIN_VALUE / 10 || num == Integer.MIN_VALUE / 10 && a < Integer.MIN_VALUE % 10){
                return 0;
            }
            num = num * 10 + a;

        }
        return num;
    }
}