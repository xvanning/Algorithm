import java.util.ArrayList;
//逆时针打印，四个循环。但是要注意从右往左和从下到上的时候，不能是单行或者单列。否则会造成重复。
public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0,r2 = matrix.length - 1,c1 = 0,c2 = matrix[0].length - 1;
        while(r1 <= r2 && c1 <= c2){
            for(int i = c1; i <= c2; i ++){
                ret.add(matrix[r1][i]);
            }
            for(int i = r1 + 1; i <= r2; i ++){
                ret.add(matrix[i][c2]);
            }
            if(r1 != r2){ //从右往左，注意不是只有一行，否则会造成重复
                for(int i = c2 - 1; i >= c1; i --){
                    ret.add(matrix[r2][i]);
                }
            }
            if(c1 != c2){//从下往上，注意不是只有一列，否则会造成重复
                for(int i = r2 - 1; i > r1; i --){
                    ret.add(matrix[i][c1]);
                }
            }
            r1 ++; r2 --; c1 ++; c2 --;
        }
        return ret;
    }
}