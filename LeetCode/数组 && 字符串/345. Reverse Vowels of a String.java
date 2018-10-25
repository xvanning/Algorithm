class Solution {
    public String reverseVowels(String s) {
        if (s.length() == 0){
            return s;
        }
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";

        int left = 0; int right = s.length() - 1;
        while (left < right){
            while (left < right && !vowels.contains(chars[left] + "")){ //跳过非元音字母
                left ++;
            }
            while (left < right && !vowels.contains(chars[right] + "")){
                right --;
            }
            swap(chars,left ++,right --);
        }
        return new String(chars);
    }
    void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}