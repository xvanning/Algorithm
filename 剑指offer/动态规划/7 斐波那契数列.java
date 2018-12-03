//经典动态规划，简单题。注意斐波那契数列为 1 1 2 3 5 。。。
public class Solution {
    public int Fibonacci(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;
        for(int i = 3; i <= n; i++){
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}