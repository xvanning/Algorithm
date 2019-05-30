import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
            return 0;
        }
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heap.add(matrix[i][j]);
                if (heap.size() > k) {
                    heap.remove();
                }

            }
        }
        return heap.peek();
    }
}