import java.util.*;
class Solution {
    List<List<String>> ret = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0){
            return ret;
        }
        List<String> list = new ArrayList<>();
        backTracking(s, 0, list);
        return ret;
    }
    public void backTracking(String s, int start, List<String> list){
        if(start == s.length()){
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int i = 1; start + i <= s.length(); i ++){
            String curString = s.substring(start, start + i);
            if(isPalindrome(curString)){
                list.add(curString);
                backTracking(s, start + i, list);
                list.remove(list.size() - 1);
            }
        }
        return;
    }
    public boolean isPalindrome(String s){
        if(s.length() == 1){
            return true;
        }
        int l = 0; int r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }
}