import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        int countZero = 0; //统计0，即万能牌的个数。
        int countNeedZero = 0; // 统计需要的万能牌数。
        int eachMinus = 0; // 每次的差值，不过要减去1。即两数相差1，不需要万能牌。两数相差2，则需要一张万能牌。以此类推。
        for (int i = numbers.length - 1; i >= 1; i--) {
            if (numbers[i] == numbers[i - 1]) {
                return false;
            }
            if (numbers[i - 1] == 0) {
                countZero = i;
                break;
            }
            eachMinus = numbers[i] - numbers[i - 1] - 1; //每次的差值，不过要减去1。即两数相差1
            countNeedZero += eachMinus;
        }
        return countZero >= countNeedZero;
    }
}