//两个不相等的元素在位级表示上必定会有一位存在不同，
//将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
//diff &= -diff 得到出 diff 最右侧不为 0 的位
//，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。

//用到异或 Leetcode 136 single Number
//原题是 Leetcode 260
//解释 ： https://leetcode.com/problems/single-number/discuss/43201/Easy-Java-solution-(tell-you-why-using-bitwise-XOR)

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : array) {
            diff ^= num;
        }

        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        for (int num : array) {
            if ((num & diff) == 0) // the bit is not set
            {
                num1[0] ^= num;
            } else // the bit is set
            {
                num2[0] ^= num;
            }
        }
    }
}