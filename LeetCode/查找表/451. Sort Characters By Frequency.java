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