// 1.按照左边界排序 2.比较右边界取最大值
import java.util.List;
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }
}



import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }
        int n = intervals[0].length;

        LinkedList<int[]> list = new LinkedList<int[]>(Arrays.asList(intervals));
        list.sort(Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> temp = new LinkedList<>();
        for (int[] in : list) {
            if (temp.isEmpty() || temp.getLast()[n - 1] < in[0]) {
                temp.add(in);
            } else {
                temp.getLast()[n - 1] = Math.max(temp.getLast()[n - 1], in[n - 1]);
            }
        }
        int[][] res = new int[temp.size()][n];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
}