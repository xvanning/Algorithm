class Solution {
    public int myAtoi(String str) {
        int index = 0;
        int length = str.length();
        int sign = 1;
        int num = 0;
        //1. Empty string
        if (length == 0) {
            return 0;
        }
        //2. Remove Spaces
        while (index < length && str.charAt(index) == ' ') {
            index ++;
        }
        if (index == length) {
            return 0;
        }
        //3. Handle signs
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }
        //4. Convert number and avoid overflow
        while (index < length) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9){
                break;
            }
            //check if total will be overflow after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < num || Integer.MAX_VALUE / 10 == num && digit > Integer.MAX_VALUE % 10){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            index ++;
        }

        return num * sign;
    }
}