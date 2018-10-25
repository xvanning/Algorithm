//思想：先把每个字符串转为array，排序之后，再转回来，变为keyString。然后以keyString为键，ArrayList为值。将各个字母添加到ArrayList里面。
//最后遍历map的键，将各个ArrayList加入到总的lists里面。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        if (strs.length == 0) {
            return lists;
        }

        for (String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyString = new String(chars);
            if (!map.containsKey(keyString)){
                ArrayList<String> currentList = new ArrayList<>();
                map.put(keyString,currentList);
            }
            map.get(keyString).add(str);
        }
        for (String key: map.keySet()){
            lists.add(map.get(key));
        }
        return lists;
    }
}