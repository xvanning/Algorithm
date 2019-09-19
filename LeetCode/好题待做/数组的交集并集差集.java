import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://blog.csdn.net/qq_36836224/article/details/84140002

class Solution {
    // leetcode 349 两数组交集，去重
    // Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2]
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num1: nums1){
            hashSet.add(num1);
        }
        for (int num: nums2){
            if (hashSet.contains(num)){
                list.add(num);
                hashSet.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }

    // leetcode 350 两数组交集，不去重
    // Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2]
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2) {
            if(map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }


}