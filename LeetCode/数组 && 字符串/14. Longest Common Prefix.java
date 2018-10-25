import java.util.Arrays;
//先排序，只会根据字符串的首字母排序。
//然后比较第一个和最后一个字符串，得到最短的字符串长度。
//然后一次比较字符串的每个字母是否相等
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        Arrays.sort(strs);
        int i = 0; int minLen = Math.min(strs[0].length(), strs[strs.length - 1].length());
        while(i < minLen && strs[0].charAt(i) == strs[strs.length - 1].charAt(i)){
            i ++;
        }
        return strs[0].substring(0,i);
    }
}