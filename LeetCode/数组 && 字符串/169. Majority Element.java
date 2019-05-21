class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major) {
                count ++;
            } else {
                count --;
                if (count == 0) {
                    major = nums[i];
                    count = 1;
                }
            }
        }
        int realCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == major) {
                realCount ++;
            }
        }

        return realCount >= nums.length / 2 ? major : 0;
    }
}