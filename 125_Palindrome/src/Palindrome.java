package com.winner;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s == "") {
            return true;
        }

        s = s.toLowerCase();
        char[] charsArr = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            if (isValidChar(charsArr[begin]) && isValidChar(charsArr[end])) {
                if (charsArr[begin] != charsArr[end]) {
                    return false;
                } else {
                    begin++;
                    end--;
                }
            }
            if (!isValidChar(charsArr[begin])) {
                begin++;
            }
            if (!isValidChar(charsArr[end])) {
                end--;
            }
        }

        return true;
    }

    private boolean isValidChar(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "race a car";
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(s));
    }
}
