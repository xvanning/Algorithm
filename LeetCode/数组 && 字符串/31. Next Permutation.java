/**
 *
 * 有如下的一个数组
    1　　2　　7　　4　　3　　1
    下一个排列为：
    1　　3　　1　　2　　4　　7
那么是如何得到的呢，我们通过观察原数组可以发现，
如果从末尾往前看，数字逐渐变大，到了2时才减小的，
然后我们再从后往前找第一个比2大的数字，是3，
那么我们交换2和3，再把此时3后面的所有数字转置一下即可，步骤如下：

1　　2　　7　　4　　3　　1

1　　2　　7　　4　　3　　1

1　　3　　7　　4　　2　　1

1　　3　　1　　2　　4　　7
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[i] < nums[j]) {
                        swap(nums, i, j);
                        reverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }

            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}