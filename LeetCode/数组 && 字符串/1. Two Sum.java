import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x)){
                ret[0] = map.get(target - x);
                ret[1] = i;
                return ret;
            }else {
                map.put(x,i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}