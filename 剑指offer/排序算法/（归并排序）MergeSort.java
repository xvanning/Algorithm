import java.util.Arrays;

class Solution{
    public void Sort(int[] arr){
        int n = arr.length;
        mergeSort(arr, 0 , n - 1);
    }

    public void mergeSort(int[] arr, int l , int r){
        if(l >= r){
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int mid, int r){
        int[] copy = Arrays.copyOfRange(arr, l, r + 1);
        int i = l;
        int j = mid + 1;
        for(int k = l; k <= r; k ++){
            if(i > mid){
                arr[k] = copy[j - l];
                j ++;
            }else if(j > r){
                arr[k] = copy[i - l];
                i ++;
            }else if(copy[i - l] <= copy[j - l]){
                arr[k] = copy[i - l];
                i ++;
            }else{
                arr[k] = copy[j - l];
                j ++;
            }
        }
    }

}