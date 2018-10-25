import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] words = str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if (chars.length != words.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (!map.get(chars[i]).equals(words[i])) {
                    return false;
                }else {
                    continue;
                }
            } else {
                if (map.containsValue(words[i])){
                    return false;
                }
                map.put(chars[i], words[i]);
            }
        }
        return true;
    }
}