import java.util.HashMap;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < A.length; i ++){
            for(int j = 0; j < B.length; j ++){
                int sum = A[i] + B[j];
                if(map.containsKey(sum)){
                    map.put(sum,map.get(sum) + 1);
                }else {
                    map.put(sum,1);
                }
            }
        }
        for (int m = 0; m < C.length; m++) {
            for (int n = 0; n < D.length; n++) {
                int sum2 =- (C[m] + D[n]);
                if (map.containsKey(sum2)){
                    count += map.get(sum2);
                }
            }
        }
        return count;
    }
}