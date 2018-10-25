//固定一个值，后面使用滑动窗口
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l ++;
                    while (l < r && nums[r - 1] == nums[r]) r --;
                    l ++; r --;
                }
                else if (l < r && sum > 0) {
                    r --;
                }
                else {
                    l ++;
                }
            }
        }
        return lists;
    }
}