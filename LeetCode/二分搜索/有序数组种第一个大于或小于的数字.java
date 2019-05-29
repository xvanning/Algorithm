// 返回的是大于等于的第一个值的位置
class Solution {
    public int ceil(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right] >= target ? right : -1;
    }

    // 返回的是小于等于的最后一个值的位置
    public int floor(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left] <= target ? left : -1;
    }
}


