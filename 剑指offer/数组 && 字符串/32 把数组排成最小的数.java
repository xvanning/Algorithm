import java.util.ArrayList;
import java.util.Arrays;
//可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，
//应该比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0){
            return "";
        }
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i ++){
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums,(S1,S2) -> (S1 + S2).compareTo(S2 + S1));
        StringBuilder sb = new StringBuilder();
        for(String s: nums){
            sb.append(s);
        }
        return sb.toString();
    }
}