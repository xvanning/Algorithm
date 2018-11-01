import java.util.ArrayList;
//滑动窗口，分别从1  2开始，如果小了，往右扩展，如果大了，左边收缩。
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int l = 1; int r = 2;
        while(l < sum / 2>){
            int curSum = ((l + r) * (r - l + 1)) / 2;
            if(curSum == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = l; i <= r; i ++){
                    list.add(i);
                }
                ret.add(list);
                l ++;
            }else if(curSum < sum){
                r ++;
            }else{
                l ++;
            }
        }
        return ret;
    }
}