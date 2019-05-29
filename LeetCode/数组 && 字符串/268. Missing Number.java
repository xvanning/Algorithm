/**
 * 缺失的数字，直接先算长度，应该的和，
 * 最后减去实际的和
 */
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int real = 0;
        for (int num : nums) {
            real += num;
        }
        return sum - real;
    }
}