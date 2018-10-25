//指针移动。初始指针位置为0
//如果当前循环的数字与要求删除的值不想等，则指针位置加一。并且将原数组的值赋值给当前指针的位置。

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int resCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[resCnt ++] = nums[i];
            }
        }
        return resCnt;
    }
}


class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int resCnt = 0;
        for (int n: nums) {
            if (n != val) {
                nums[resCnt ++] = n;
            }
        }
        return resCnt;
    }
}
