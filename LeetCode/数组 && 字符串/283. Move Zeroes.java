// 原地(in place)解决该问题
// 时间复杂度: O(n)
// 空间复杂度: O(1)

/**
 *
 *很简单一道题，直接双指针，k指针永远要指向0，
 * i遍历，如果遇到为零的，K不动，I++
 * 如果遇到不为零的，和K指针所指元素交换。然后K++，I++
 * @param nums
 */

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) { //改进版本，不需要和不为0的自己交换。
                    swap(nums, i, k);
                    k++;
                }else {
                    k ++;
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}



    public void moveZeroes(int[] nums) {

        int k = 0; // nums中, [0...k)的元素均为非0元素

        // 遍历到第i个元素后,保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        // 同时, [k...i] 为 0
        for(int i = 0 ; i < nums.length ; i ++)
            if(nums[i] != 0)
                swap(nums, k++, i);
    }