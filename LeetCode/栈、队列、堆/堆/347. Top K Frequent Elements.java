//桶排序方法：
import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> topKList = new ArrayList<>();
        if (nums.length == 0 || k <= 0) {
            return topKList;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }
        List<Integer>[] lists = new List[nums.length + 1];
        for (int key: map.keySet()){
            int currentCount = map.get(key);
            if (lists[currentCount] == null){
                lists[currentCount] = new ArrayList<>();
            }
            lists[currentCount].add(key);
        }
        for (int i = lists.length - 1; i >= 0 && topKList.size() < k; i --){
            List<Integer> currentList = lists[i];
            if (currentList != null){
                topKList.addAll(currentList);
            }
        }
        return topKList;
    }
}

/**
算法复杂度为O（nlogm）
1、先将给定的数组nums，输入到map集合中，key为nums的值，value为对应key的频率。
2、使用内部类的方式，定义compare比较value的大小，从而比较数组频率的大小。
3、放入到优先队列（底层为最小堆）进行维护：遍历key，当优先队列中的元素不足K个，则先加到K个。然后进行map中key的频率和队列中队首已有key的频率进行比较，如果队首的key的频率小则，出队，替换当前key。
4、最后进行输出到list之中。
**/

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0 || k <= 0) {
            return list;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for (int key : map.keySet()){
            if (queue.size() < k){
                queue.offer(key);
            }else {
                if (map.get(key) > map.get(queue.peek())){
                    queue.poll();
                    queue.offer(key);
                }
            }
        }
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }
}
