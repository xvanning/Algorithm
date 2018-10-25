import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) {
            return lists;
        }
        backTracking(k, n, 1, new ArrayList<Integer>());
        return lists;
    }

    private void backTracking(int k, int n, int start, ArrayList<Integer> list) {
        if (n < 0) {
            return;
        }
        if (k == list.size() && n == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9 - (k - list.size()) + 1 ; i++) {
            if (i > n){
                break;
            }
            list.add(i);
            //System.out.println("curI: " + i + " ,curN: " + n + " ,curList: " + list + "  ,curLists: " + lists);
            backTracking(k, n - i, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
