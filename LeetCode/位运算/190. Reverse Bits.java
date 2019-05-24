/**
 * 我们只需要把要翻转的数从右向左一位位的取出来，
 * 如果取出来的是1，我们将结果res左移一位并且加上1；
 * 如果取出来的是0，我们将结果res左移一位，然后将n右移一位即可
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res = (res << 1) + 1;
            } else {
                res = res << 1;
            }
            n = n >> 1;
        }
        return res;
    }
}