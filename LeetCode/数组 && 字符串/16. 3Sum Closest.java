import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i ++){
            int l = i + 1; int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > target){
                    r --;
                }else {
                    l ++;
                }
                if (Math.abs(sum - target) < min){
                    min = Math.abs(sum - target);
                    res = sum;
                }
            }

        }
        return res;
    }
}