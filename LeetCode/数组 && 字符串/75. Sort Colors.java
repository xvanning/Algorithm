// 75. Sort Colors
// https://leetcode.com/problems/sort-colors/description/
//
// 三路快速排序的思想
// 对整个数组只遍历了一遍
// 时间复杂度: O(n)
// 空间复杂度: O(1)

class Solution {
    public void sortColors(int[] nums) {
        int zero = -1; // [0...zero] == 0
        int two = nums.length; // [two...n-1] == 2
        for (int i = 0; i < two;){
            if (nums[i] == 1) {
                i ++;
            } else if (nums[i] == 2) {
                swap(nums,i,--two);
            }else {
                swap(nums, i++,++zero);
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//改动从for循环变为while循环。
class Solution {
    public void sortColors(int[] nums) {
        int zero = -1; // [0...zero] == 0    // int lt = l;   arr[l+1...lt] < v 
        int two = nums.length; // [two...n-1] == 2  // int gt = r + 1;  arr[gt...r] > v
        int i = 0;             //int i = l+1;    arr[lt+1...i) == v
        while(i < two){
            if (nums[i] == 1) {
                i ++;
            } else if (nums[i] == 2) {
                swap(nums,i,--two);
            }else {
                swap(nums, i++,++zero);
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}