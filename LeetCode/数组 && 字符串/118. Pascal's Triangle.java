import java.util.ArrayList;
import java.util.List;

// 杨辉三角
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);

            for (int j = 1; j < i; j++) {
                cur.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j)); // 上一行的前一个值和当前下表值相加
            }
            if (i > 0) {
                cur.add(1);
            }
            res.add(cur);
        }
        return res;
    }
}