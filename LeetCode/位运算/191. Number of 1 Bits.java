// 每次与最后一位相与，如果为1，count加1。 然后不断循环右移原数字。
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count += 1;
            }
            n = n >> 1;
        }
        return count;
    }
}

//减一相与，举例 1100 减一之后是1011；相与之后变成 1000；重复上面步骤。
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
}