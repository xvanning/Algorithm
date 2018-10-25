//https://leetcode.com/problems/triangle/discuss/38809/Simple-O(n)-extra-space-Java-Solution-with-explanation
import java.util.List;
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i = triangle.size()-1;i >= 0;i--){
            for(int j = 0;j < triangle.get(i).size(); j++){
                //System.out.println("curI: " + i + " ,curJ: " + j +  " ,curNum: " + triangle.get(i).get(j) + " ,A[0]: " + A[0] + " ,A[1]: " + A[1]  + " ,A[2]: " + A[2] + " ,A[3]: " + A[3]);
                A[j] = Math.min(A[j],A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}