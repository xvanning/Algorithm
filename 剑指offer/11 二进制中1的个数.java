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