import java.util.HashSet;
import java.util.Iterator;

class Solution {
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
}