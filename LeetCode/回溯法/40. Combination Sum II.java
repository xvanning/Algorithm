class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i > start && candidates[i] == candidates[i-1]) continue; // skip duplicates
            list.add(candidates[i]);
            backTracking(candidates, target - candidates[i], i + 1, list); // 注意是 i+1；
            list.remove(list.size() - 1);
        }
    }
}