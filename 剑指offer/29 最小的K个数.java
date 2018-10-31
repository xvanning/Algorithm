import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

//经典topK问题。时间复杂度为O(nlogK)，结合leetcode347
//应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
//维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        if(input.length == 0 || k <= 0 || k > input.length){
            return list;
        }

        for(int num : input){
            if(queue.size() < k){
                queue.add(num);
            }else{
                if(num < queue.peek()){
                    queue.remove();
                    queue.add(num);
                }
            }
        }
        while(!queue.isEmpty()){
            list.add(queue.remove());
        }
        return list;
    }
}

//快排partition方法 & findKth是非递归的
//快排partition方法会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，
//此时 a[j] 就是数组的第 j 大元素。可以利用这个特性找出数组的第 K 个元素，
//这种找第 K 个元素的算法称为快速选择算法。
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length == 0 || k <= 0 || k > input.length){
            return list;
        }
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        /* partition返回的是下标，所以传入的参数K需要减去一，才能与下标对应。 */
        int kthMin = findKthMin(input, 0, input.length - 1, k - 1);
        for(int i = 0; i < k; i ++){
            list.add(input[i]);
        }
        return list;
    }
    public int findKthMin(int [] nums, int l, int r, int k){
        while(l < r){
            int p = partition(nums, l , r);
            if(p == k){
                return nums[p];
            }else if(p > k){
                r = p - 1;
            }else {
                l = p + 1;
            }
        }
        return nums[l];
    }
    public int partition(int [] nums, int l, int r){
        swap(nums, l, (int)(Math.random() * ( r - l + 1)) + l );
        int v = nums[l];
        int j = l;
        for(int i = l + 1; i <= r; i ++){
            if(nums[i] < v){
                j ++;
                swap(nums, i, j);
            }
        }
        swap(nums, l, j);
        return j;
    }
    public void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 快排partition方法 & findKth是递归的
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || k < 1 || k > input.length) {
            return list;
        }
        int KthMin = findKthMin(input, 0, input.length - 1, k - 1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public int findKthMin(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int p = partition(nums, l, r);
        if (p == k) {
            return nums[p];
        } else if (p < k) {
            return findKthMin(nums, p + 1, r, k);
        } else {
            return findKthMin(nums, l, p - 1, k);
        }

    }

    public int partition(int[] nums, int l, int r) {
        swap(nums, l, (int) (Math.random() * (r - l + 1) + l));
        int v = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < v) {
                swap(nums, ++j, i);
            }
        }
        swap(nums, l, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

