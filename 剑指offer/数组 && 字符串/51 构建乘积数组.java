//leetcode 238. Product of Array Except Self
//O（n）复杂度。 构建一个矩阵。斜对角是1的矩阵。
import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        for(int i = 1; i < A.length; i ++){
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for(int i = A.length - 2; i >= 0; i --){
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}

//O（n）复杂度，暴力解法
import java.util.Arrays;
public class Solution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        Arrays.fill(B, 1);
        for(int i = 0; i < A.length; i ++){
            for(int j = 0; j < A.length; j ++){
                if(i == j){
                    continue;
                }
                B[i] *= A[j];
            }
        }
        return B;
    }
}

