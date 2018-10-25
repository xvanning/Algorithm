class Solution {
    public String reverseString(String s) {
        int left = 0; int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right){
            swap(chars, left ++,right --);
        }
        return new String(chars);  //注意这里需要用new String；
    } 

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}