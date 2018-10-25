//回溯法，重复的跳过
import java.util.*;
class Solution {
    List<List<Integer>> ret;
    boolean used[];
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0){
            return ret;
        }
        ret = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, 0, new ArrayList<Integer>());
        return ret;
    }
    public void backTracking(int[] nums, int start, List<Integer> list){
        if(start == nums.length){
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i ++){ //使用过的跳过
            if(used[i]){
                continue;
            }
            if(i != 0 && nums[i - 1] == nums[i] && used[i - 1] == true){ //重复的跳过
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            backTracking(nums, start + 1, list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
        return;
    }
}