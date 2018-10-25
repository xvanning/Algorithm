//基于组合题77，即CN0 一直到 CNN；
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length <= 0) {
            return lists;
        }
        Arrays.sort(nums);
        for (int k = 0; k <= nums.length; k++) {
            backTracking(nums, 0, new ArrayList<Integer>(), k);
        }
        return lists;
    }

    private void backTracking(int[] nums, int start, ArrayList<Integer> list, int k) {
        if (list.size() == k){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length - (k - list.size()) + 1; i ++){
            if (i > start && nums[i - 1] == nums[i]){
                continue;
            }
            list.add(nums[i]);
            backTracking(nums,i + 1,list,k);
            list.remove(list.size() - 1);
        }
    }
}


//法二：把每一步的list都加进入到lists中
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length <= 0) {
            return lists;
        }
        Arrays.sort(nums);
        backTracking(nums, 0, new ArrayList<Integer>());
        return lists;
    }

    private void backTracking(int[] nums, int start, ArrayList<Integer> list) {
        lists.add(new ArrayList<>(list)); //把每一步的list都加进入到lists中
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            backTracking(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}