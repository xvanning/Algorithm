//法1：
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res,sum);
        }
        return res;
    }
}

//法2：
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum <= 0){
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}