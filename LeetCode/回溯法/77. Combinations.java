import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n){
            return ret;
        }
        backTracking(n,k,1,new ArrayList<>());
        return ret;
    }

    private void backTracking(int n, int k, int start, List<Integer> list) {
        if (list.size() == k){
            ret.add(new ArrayList<>(list));
            return;
        }
        //在递归结束后list总共要有k个元素，所以在递归过程中的一层，必须要有k - list.size()个元素。即
        //在[i ... n ]中要有k - list.size()个元素，
        //所以i必须小于等于 n - (k - list.size()) + 1；
        for (int i = start; i <= n - (k - list.size()) + 1; i ++){
            list.add(i);
            backTracking(n,k,i + 1,list);
            list.remove(list.size() - 1);
        }
    }
}