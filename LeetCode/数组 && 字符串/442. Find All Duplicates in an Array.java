//方法1： 交换数字，使其在下标的位置

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] == -1){
                    break;
                }
                if (nums[nums[i] - 1] == nums[i]) {
                    if (nums[i] != -1) {
                        list.add(nums[i]);
                        nums[i] = -1;
                        break;
                    }
                }
                swap(nums, nums[i] - 1, i);
            }
        }
        return list;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//方法2： 找下标位置的数字。使其为负数。当后面有重复数字的时候，则会访问到负数，添加进list中
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0){
                list.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return list;
    }
}