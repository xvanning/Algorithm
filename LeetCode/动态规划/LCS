/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */

//最长公共字串，暴力和dp方法
class Solution {
    // 暴力解法
    private static String getLCS(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return "";
        }
        String min = s1.length() <= s2.length() ? s1 : s2;
        String max = s1.length() > s2.length() ? s1 : s2;
        for (int i = 0; i < min.length(); i++) {
            for (int l = 0, r = min.length() - i; r <= min.length(); l++, r++) {
                String cur = min.substring(l, r);
                if (max.contains(cur)) {
                    return cur;
                }
            }
        }
        return "";
    }

    // 通用解法，矩阵，易懂
    private static int lengthOfLCS(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        int res = 0;
        int pos = 0; // 输出公共字串为 subString(pos - max, pos);
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    pos = i;
                } else {
                    matrix[i][j] = 0;
                }
                res = Math.max(res, matrix[i][j]);
            }
        }

        return res;
    }

    // dp解法
    private static String getLCSDP(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return "";
        }
        // 横向
        int len1 = s1.length();
        // 纵向
        int len2 = s2.length();
        int[] topLine = new int[len1];
        int[] curLine = new int[len1];
        int maxLen = 0;
        int pos = 0;
        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < len1; j++) {
                if (s2.charAt(i) == s1.charAt(j)) {
                    if (j == 0) {
                        curLine[j] = 1;
                    } else {
                        curLine[j] = topLine[j - 1] + 1;
                    }
                    if (curLine[j] > maxLen) {
                        maxLen = curLine[j];
                        pos = j;
                    }
                }
            }
            topLine = curLine;
            curLine = new int[len1];
        }
        return s1.substring(pos - maxLen + 1, pos + 1);
    }
}