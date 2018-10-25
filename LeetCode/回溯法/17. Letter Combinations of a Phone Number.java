import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();
    String numLetterMaps[] = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return list;
        }
        backTracking(digits,0,"");
        return list;
    }
    public void backTracking(String digits, int start, String curLetters){
        if(start == digits.length()){
            list.add(curLetters);
            return;
        }
        char c = digits.charAt(start);
        String numLetter = numLetterMaps[c - '0'];
        for(int i = 0; i < numLetter.length(); i ++){
            backTracking(digits, start + 1, curLetters + numLetter.charAt(i));
        }
        return;
    }
}