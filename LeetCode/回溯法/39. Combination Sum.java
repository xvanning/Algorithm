//组合问题。注意递归的开头是start，即不能取前面已经取过的值
import java.util.*;
class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0 || target <= 0){
            return lists;
        }
        Arrays.sort(candidates);
        backTracking(candidates,target,0,new ArrayList<>());
        return lists;
    }
    public void backTracking(int[] candidates, int target, int start, List<Integer> list){
        if(target < 0){
            return;
        }
        if(target == 0){
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i < candidates.length; i ++){
            if (candidates[i] > target){
                break;
            }
            list.add(candidates[i]);
            backTracking(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}