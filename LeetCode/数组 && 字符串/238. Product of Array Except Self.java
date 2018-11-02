class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] B = new int[nums.length];
        B[0] = 1;
        for(int i = 1; i < nums.length; i ++){
            B[i] = B[i - 1] * nums[i - 1]; //左半边矩阵
        }
        int temp = 1;
        for(int i = nums.length - 2; i >= 0; i --){
            temp *= nums[i + 1]; // 右半边矩阵
            B[i] *= temp; // 左右半边相乘。
        }
        return B;
    }
}