public class Solution {
    public int RectCover(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1 || target == 2){
            return target;
        }
        int[] fib = new int[target + 1];
        fib[1] = 1;
        fib[2] = 2;
        for(int i = 3; i <= target; i ++){
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[target];
    }
}