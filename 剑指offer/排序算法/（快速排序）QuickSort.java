class Solution{
    public void Sort(int[] arr){
        int n = arr.length;
        quickSort(arr, 0, n - 1);
    }

    public void quickSort(int[] arr, int l , int r){
        if(l >= r){
            return;
        }
        int p = partition(arr, l , r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    public int partition(int[] arr, int l, int r){
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = arr[l];
        int j = l;

        for(int i = l + 1; i <= r; i ++){
            if(arr[i] < v){
                j ++;
                if(i != j) {
                    swap(arr, i, j);
                } 
            }
        }
        swap(arr, l, j);

        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
