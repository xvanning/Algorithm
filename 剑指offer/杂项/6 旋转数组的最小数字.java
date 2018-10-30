//注意关注leetcode 33 Search in Rotated Sorted Array
import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }

        int left = 0; int right = array.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(array[left] == array[mid] && array[right] == array[mid]){
                return finMin(array);
            }
            if(array[mid] <= array[right]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return array[left];
    }

    public int finMin(int[] array){
        int min = 0;
        for(int i = 0; i < array.length; i ++){
            if(array[min] > array[i]){
                min = i;
            }
        }
        return array[min];
    }
}

//leetcode 33 Search in Rotated Sorted Array
//https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
             if (nums[m] <= nums[r]) {
                if (target > nums[m] && target <= nums[r]) l = m + 1;
                else r = m;
            } else {
                if (target <= nums[m] && target >= nums[l]) r = m;
                else l = m + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}