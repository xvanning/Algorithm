import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() == 0){
            return list;
        }
        int[] path = new int[4];
        backTracking(s,0,path,0);
        return list;
    }
    public void backTracking(String s, int start, int[] path, int segment){
        if(start == s.length() && segment == 4){
            String curString = path[0] + "." + path[1] + "." + path[2] + "." + path[3];
            list.add(curString);
        }
        if(segment == 4){
            return;
        }
        for(int i = 1; i <= 3 && start + i <= s.length(); i ++){
            int part = Integer.parseInt(s.substring(start, start + i));
            if(part > 255 || (i > 1 && s.charAt(start) == '0' )){
                break;
            }
            path[segment] = part;
            backTracking(s,start + i, path, segment + 1);
        }
        return;
    }
}