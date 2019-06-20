/*
 *
 */
class Solution {
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[0];
        }
        int[] res = new int[num + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = NumberOf1(i);
        }
        return res;
    }
    //减一相与，举例 1100 减一之后是1011；相与之后变成 1000；重复上面步骤。
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
}