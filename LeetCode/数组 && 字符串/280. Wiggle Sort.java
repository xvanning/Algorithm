import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2) {
            return;
        }
        for (int i = 2; i < nums.length; i += 2) {
            swap(nums, i, i - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}