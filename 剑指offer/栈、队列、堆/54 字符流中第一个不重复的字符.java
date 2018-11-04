import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
//对应剑指offer 34 第一次只出现一次的字符位置
//应用队列和一个数组（ASCII有256中情况，储存字母）
//如果多次，就从队列中移除
public class Solution {

    int[] cnt = new int[256];
    Queue<Character> queue = new LinkedList<>();

    // Insert one char from stringstream
    public void Insert(char ch) {
        queue.add(ch);
        cnt[ch]++;

        while (!queue.isEmpty() && cnt[queue.peek()] > 1) {
            queue.remove();
        }

    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}

// LinkedHashMap方法
import java.util.*;
public class Solution {
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
    // Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        }else{
            map.put(ch, 1);
        }
    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for(char key: map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }
        return '#';
    }
}