import java.util.*;
//HashMap经典题，先遍历一遍。保存每个字符出现的次数，然后再从头开始遍历，如果出现次数为1的字符，则返回当前的下标。
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) {
            return -1;
        }
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}