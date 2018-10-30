public class Solution {
    public int JumpFloorII(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1 || target == 2){
            return target;
        }
        int[] fib = new int[target + 1];
        fib[1] = 1;
        fib[2] = 2;
        for(int i = 3; i <= target; i++){
            for(int j = i - 1; j >= 1; j --){
                fib[i] += fib[j];
            }
            fib[i] += 1;
        }
        return fib[target];
    }
}