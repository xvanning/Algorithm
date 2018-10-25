import java.util.TreeSet;
// 220. Contains Duplicate III
// https://leetcode.com/problems/contains-duplicate-iii/description/
// 时间复杂度: O(nlogk)
// 空间复杂度: O(k)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            Long ceil = set.ceiling((long)nums[i] - (long)t);
            if (ceil != null && ceil <= (long) nums[i] + (long) t){
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() == k + 1){
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}