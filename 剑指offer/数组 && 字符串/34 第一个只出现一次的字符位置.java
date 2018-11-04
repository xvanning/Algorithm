import java.util.*;
//对应剑指offer 54 字符流中第一个不重复的字母，可以用队列做。
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

//使用队列方法
import java.util.*;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str.length() == 0){
            return -1;
        }
        char[] chars = str.toCharArray();
        int[] cnt = new int[256];
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < chars.length; i ++){
            queue.add(chars[i]);
            cnt[chars[i]] ++ ;
        }
        while(!queue.isEmpty() && cnt[queue.peek()] > 1){
            queue.remove();
        }
        if(queue.isEmpty()){
            return -1;
        }
        for(int i = 0; i < chars.length; i ++){
            if(chars[i] == queue.peek()){
                return i;
            }
        }
        return -1;
}
}