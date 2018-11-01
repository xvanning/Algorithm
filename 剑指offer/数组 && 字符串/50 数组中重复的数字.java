public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {  // 这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素放到第 i 个位置上。
        if (numbers == null || length<= 0){
            return false;
        }
        for (int i = 0; i < length; i++){
            if (numbers[i] < 0 || numbers[i] > length){
                return false;
            }
        }

        for (int i = 0; i < length; i ++){
            while (numbers[i] != i){
                if (numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers,i,numbers[i]);
            }
        }
        return false;
    }
    public void swap(int[] arr,int i,int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}



//方法2：使用哈希表扫描。
import java.util.HashMap;

public class Solution {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        HashMap<Integer,Integer> map = new HashMap<>();
        if (numbers == null || length<= 0){
            return false;
        }
        for (int i=0; i < length; i++){
            if (numbers[i] < 0 || numbers[i] > length){
                return false;
            }
        }
        for (int num : numbers) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int key: map.keySet()){
            if (map.get(key) > 1){
                duplication[0] = key;
                return true;
            }
        }
        return false;
    }
}