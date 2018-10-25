//设置set和一个窗口大小，来滑动。位置set大小为K
import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size() == k + 1){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}