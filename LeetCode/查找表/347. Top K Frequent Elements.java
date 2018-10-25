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
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for (int num: nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1 );
            } else {
                map.put(num, 1);
            }
        }

        for (int key: map.keySet()){
            if (queue.size() < k){
                queue.add(key);
            }else if (map.get(key) > map.get(queue.peek())){
                queue.remove();
                queue.add(key);
            }
        }

        while (!queue.isEmpty()){
            list.add(queue.remove());
        }

        return list;
    }
}