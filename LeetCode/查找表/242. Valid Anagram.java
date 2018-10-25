import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        char[] charsS = s.toCharArray();
        for (char c : charsS){
            if (map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }
        char[] charsT = t.toCharArray();
        for (char b: charsT){
            if (map.containsKey(b)){
                map.put(b,map.get(b) - 1);
                if (map.get(b) == 0) {
                    map.remove(b);
                }
            }else {
                return false;
            }
        }
        return map.isEmpty();
    }
}