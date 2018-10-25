//归并排序的思想，不过因为是有序的数组。指针是从后往前移动，

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; int j = n - 1; int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k --] = nums1[i] > nums2[j] ? nums1[i --] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k --] = nums2[j --];
        }
    }
}