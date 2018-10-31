import java.util.ArrayList;
import java.util.Arrays;
//经典回溯法，全排列；
public class Solution {
    private ArrayList<String> ret;
    private boolean[] used;
    public ArrayList<String> Permutation(String str) {
        ret = new ArrayList<>();
        used = new boolean[str.length()];
        if (str.length() == 0) {
            return ret;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backTracking(chars, 0, new StringBuilder());
        return ret;
    }
    public void backTracking(char[] chars, int start, StringBuilder sb){
        if(start == chars.length){
            ret.add((new StringBuilder(sb).toString()));
        }
        for(int i = 0; i < chars.length; i ++){
            if(used[i] == true){ // 使用过的跳过。
                continue;
            }
            if(i != 0 && chars[i - 1] == chars[i] && used[i - 1] == false){ //重复的跳过
                continue;
            }
            used[i] = true;
            sb.append(chars[i]);
            backTracking(chars, start + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}