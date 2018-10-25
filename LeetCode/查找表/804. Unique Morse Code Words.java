import java.util.TreeSet;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> treeSet = new TreeSet<>();
        for (String word: words){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                String Morse = codes[word.charAt(i) - 'a'];
                stringBuilder.append(Morse);
            }
            treeSet.add(stringBuilder.toString());
        }
        return treeSet.size();
    }
}