class Solution {
    // 只算长度，不返回具体公共子序列
    public static int longestCommonSequence(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        int res = 0;
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
                if (matrix[i][j] > res) {
                    res = matrix[i][j];
                }
            }
        }
        return res;
    }
}

// 变形题，要打印全部的公共子序列
public class Main {

    public static void main(String[] args) {
        String s1 = "abcbdab";
        String s2 = "bdcaba";

        int max = longestCommonSequence(s1, s2);
        System.out.println(max);
    }

    public static int longestCommonSequence(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        int res = 0;
        int[][] direction = new int[s1.length() + 1][s2.length() + 1];
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    direction[i][j] = 1;
                } else if (matrix[i - 1][j] > matrix[i][j - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                    direction[i][j] = 2;
                } else if (matrix[i][j - 1] > matrix[i - 1][j]) {
                    matrix[i][j] = matrix[i][j - 1];
                    direction[i][j] = 3;
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                    direction[i][j] = 4;
                }
                res = Math.max(res, matrix[i][j]);
            }
        }

        printSubSequence(direction, s1, "", res, s1.length(), s2.length());

        return res;
    }

    private static void printSubSequence(int[][] direction, String s1, String lcs, int maxLen, int i, int j) {
        if (i == 0 || j == 0) {
            if (lcs.length() == maxLen) {
                StringBuilder sb = new StringBuilder(lcs);
                System.out.println(sb.reverse().toString());
            }
        }
        int curDir = direction[i][j];
        switch (curDir) {
            case 1:
                lcs = lcs + s1.charAt(i - 1);
                printSubSequence(direction, s1, lcs, maxLen, i - 1, j - 1);
                break;
            case 2:
                printSubSequence(direction, s1, lcs, maxLen, i - 1, j);
                break;
            case 3:
                printSubSequence(direction, s1, lcs, maxLen, i, j - 1);
                break;
            case 4:
                printSubSequence(direction, s1, lcs, maxLen, i - 1, j);
                printSubSequence(direction, s1, lcs, maxLen, i, j - 1);
                break;
        }
    }

}
