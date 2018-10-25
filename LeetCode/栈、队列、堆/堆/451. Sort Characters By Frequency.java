//桶排序方法
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String frequencySort(String s) {
        if (s.length() == 0) {
            return s;
        }
        //根据字符串中出现的次数构建字符映射
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int maxCount = 1;
        for (char c: chars){
            if (map.containsKey(c)){
                map.put(c,map.get(c) + 1);
                maxCount = Math.max(maxCount,map.get(c));
            }else {
                map.put(c,1);
            }
        }
        //创建一个数组，其中数组的索引表示字符串中出现的字符数
        List<Character>[] lists = new List[maxCount + 1];
        for (char key : map.keySet()){
            int count = map.get(key);
            if (lists[count] == null){
                lists[count] = new ArrayList<>();
            }
            lists[count].add(key);
        }
        //从数组的末尾到开头迭代，并在每个索引处将每个字符追加到返回字符串中多次。
        StringBuilder res = new StringBuilder();
        for (int i = lists.length - 1; i >= 1; i --){
            List<Character> currentList = lists[i];
            if (currentList != null) {
                for (char c: currentList){
                    for (int j = 0; j < i; j ++){
                        res.append(c);
                    }
                }
            }
        }
        return res.toString();
    }
}

//使用优先队列方法：算法复杂度为O（nlogm）
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public String frequencySort(String s) {
        if (s.length() == 0) {
            return s;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else {
                map.put(c,1);
            }
        }
        Queue<Character> queue = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for (char key: map.keySet()){
            queue.offer(key);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            int count = map.get(c);
            while (count != 0){
                sb.append(c);
                count --;
            }
        }
        return sb.toString();
    }
}