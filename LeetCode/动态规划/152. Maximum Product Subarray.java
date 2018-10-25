//要保存最大或者最小值，因为负负得正。
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int curMax = Math.max(cur,Math.max(max * cur, min * cur)); 
            int curMin = Math.min(cur,Math.min(max * cur, min * cur));
            res = Math.max(res,curMax);
            
            max = curMax;
            min = curMin;
            
        }
        return res;
    }
}