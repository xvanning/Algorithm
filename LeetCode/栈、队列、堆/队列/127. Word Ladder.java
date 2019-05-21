import java.util.*;

// 运用BFS ，注意先要把wordList去重
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        Set<String> dic = new HashSet<>(wordList);
        int minLength = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                if (curWord.equals(endWord)) {
                    return minLength;
                }
                char[] curChars = curWord.toCharArray();
                for (int j = 0; j < curChars.length; j++) {
                    char preChar = curChars[j];
                    for (char nextChar = 'a'; nextChar <= 'z'; nextChar++) {
                        curChars[j] = nextChar;
                        String nextWord = new String(curChars);
                        if (dic.contains(nextWord) && !visited.contains(nextWord)) {
                            queue.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                    curChars[j] = preChar;
                }
            }
            minLength++;
        }

        return 0;
    }
}