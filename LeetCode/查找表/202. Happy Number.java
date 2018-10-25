///类似链表查找环，设置两个不同不同步长，有环则一定会相遇。说明不是快乐数字；
class Solution {
    public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while (x > 1){
            x = cal(x);
            if (x == 1) return true;
            y = cal(cal(y));
            if (y == 1) return true;
            if (x == y) return false;
        }
        return true;
    }
    public int cal(int n){
        int ret = 0;
        while (n > 0){
            ret = ret + (n % 10) * (n % 10);
            n = n / 10;
        }
        return ret;
    }
}

//如果不是快乐数字，则一直计算下去一定存在重复。则hashSet无法添加。
import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (set.add(n)){
            if (n == 1){
                return true;
            }
            n = cal(n);
        }
        return false;
    }
    public int cal(int n){
        int ret = 0;
        while (n > 0){
            ret = ret + (n % 10) * (n % 10);
            n = n / 10;
        }
        return ret;
    }
}