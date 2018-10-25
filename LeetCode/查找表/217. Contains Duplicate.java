//此题也可以用hashSet

import java.util.HashMap;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n: nums){
            if (map.containsKey(n)){
                return true;
            }else {
                map.put(n,1);
            }
        }
        return false;
    }
}