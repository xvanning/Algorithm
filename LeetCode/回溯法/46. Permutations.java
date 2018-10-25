import java.util.ArrayList;
import java.util.List;

//回溯法，使用过的跳过
class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    boolean[] used ;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return ret;
        }
        used = new boolean[nums.length];
        backTracking(nums,0,new ArrayList<>());
        return ret;
    }
    public void backTracking(int[] nums, int start, List<Integer> list){
        if(start == nums.length){
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i ++){
            if(used[i]){ //使用过的跳过
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            backTracking(nums, start + 1, list);
            list.remove(list.size() - 1);
            used[i] = false;

        }
    }
}