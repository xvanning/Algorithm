class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num1: nums1){
            if (!map.containsKey(num1)){
                map.put(num1,1);
            }else {
                map.put(num1,map.get(num1) + 1);
            }

        }
        for (int num2: nums2){
            if (map.containsKey(num2)){
                list.add(num2);
                map.put(num2,map.get(num2) - 1);
                if (map.get(num2) == 0){
                    map.remove(num2);
                }
            }
        }

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}