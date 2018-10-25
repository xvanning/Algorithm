//比较数的左右两个数字。
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int div = 1;
        while (x / div >= 10){
            div = div * 10;
        }
        while (x != 0){
            int l = x / div; //左边的数字
            int r = x % 10; //右边的数字
            if (l != r){
                return false;
            }
            x = (x % div) / 10;
            div = div / 100;
        }
        return true;
    }
}


//最优解
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int retNum = 0;
        while (x > retNum){ //不断比较左右两边是否相等
            retNum = retNum * 10 + x % 10;
            x = x / 10;
        }
        return (x == retNum || x == retNum / 10); // x == retNum / 10 奇数的时候用。
    }
}