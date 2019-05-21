import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] numString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numString[i] = nums[i] + "";
        }
        Arrays.sort(numString, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (int i = 0; i < numString.length; i++) {
            sb.append(numString[i]);
        }
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}