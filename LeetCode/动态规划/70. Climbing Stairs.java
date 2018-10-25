class Solution {
    public int climbStairs(int n) {
        if(n <= 0 ){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1; nums[2] = 2;
        for(int i = 3; i < nums.length; i ++){
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums[n];
    }
}