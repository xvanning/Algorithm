import java.util.Arrays;
// 映射，空间复杂度o（n）
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        int[] copy = Arrays.copyOf(nums,nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = copy[i];
        }
    }
}

// 旋转，in-place
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}