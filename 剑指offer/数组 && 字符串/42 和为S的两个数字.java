import java.util.ArrayList;

//滑动窗口
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array.length < 2) {
            return list;
        }
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int curSum = array[l] + array[r];
            if (curSum == sum) {
                list.add(array[l]);
                list.add(array[r]);
                break;
            } else if (curSum > sum) {
                r--;
            } else {
                l++;
            }
        }
        return list;
    }
}