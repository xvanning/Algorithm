class Solution {
    public void heapSort(int[] arr){
         int n = arr.length;
         //把数组进行heapify。构建最大堆
        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n - 1
         for(int i = (n - 1) / 2; i >= 0; i --){
             shiftDown(arr,n,i);
         }
         //排序过程
         for(int i = n - 1; i >= 1; i --){
             swap(arr,i,0); //将堆顶最大的元素，和最后一个元素交换。同时堆的个数会减一。
             shiftDown(arr,i,0); //每次堆的个数会减一，所以对应参数为i；
         }
    }
     /*  arr 表示当前的数组
     *   n 表示堆的个数
     *   k 表示当前进行操作的数组下标
     */
     private void shiftDown(int[] arr, int n, int k) {
         while (2 * k + 1 < n){
             int j = 2 * k + 1; //在此轮循环中，arr[k]和arr[j]交换位置
             //如果存在右孩子，并且右孩子的值比左孩子大，则将j变为右孩子的下标
             if(j + 1 < n && arr[j + 1] > arr[j]){
                 j += 1;
             }
             if(arr[k] >= arr[j]){ //如果当前节点比左右孩子都大，则结束下沉
                 break;
             }
             swap(arr,j, k);
             k = j; //最后需要将下标值，变为左或右孩子的下标，继续进行操作
         }
     }

     public void swap(int[] arr, int i, int j ){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
 }

