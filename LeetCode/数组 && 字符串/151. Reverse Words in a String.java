//先整体反转，再逐个反转。最后去除空格

public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);
        reverseWords(chars);
        return cleanSpaces(chars,s.length());
    }


    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private void reverseWords(char[] chars){
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i <= chars.length; i ++) {
            if (i == chars.length || chars[i] == ' ') {
                endIndex = i - 1;
                reverse(chars, startIndex, endIndex);
                startIndex = i + 1;
            }
        }
    }
    // trim leading, trailing and multiple spaces
    public String cleanSpaces(char[] chars, int length) {
        int i = 0, j = 0;

        while (j < length) {
            while (j < length && chars[j] == ' ') j++;             // skip spaces
            while (j < length && chars[j] != ' ') chars[i++] = chars[j++]; // keep non spaces
            while (j < length && chars[j] == ' ') j++;             // skip spaces
            if (j < length) chars[i++] = ' ';                      // keep only one space
        }

        return new String(chars).substring(0, i);
    }
}


//方法二：使用StringBuilder
public class Solution {
	public String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reversed.length() != 0) {
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}
}