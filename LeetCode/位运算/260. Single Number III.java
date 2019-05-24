//对应剑指offer 40 数组中只出现一次的数字
class Solution {
    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for(int num : nums){
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;
        int[] ret = new int[2];
        for(int num: nums){
            if((diff & num) == 0){ // the bit is not set
                ret[0] ^= num;
            }else{
                ret[1] ^= num; // the bit is set
            }
        }
        return ret;
    }
}