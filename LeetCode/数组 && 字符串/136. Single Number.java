class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int num: nums){
            ret ^= num; //异或
        }
        return ret;
    }
}