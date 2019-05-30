/**
 * 2的倍数，减去1，则所有其他位都是1，相与为0
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        n = n & (n - 1);
        return n == 0;
    }
}

/**
 * 不断右移一位，最后看1的个数是否为1；
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count == 1;
    }
}