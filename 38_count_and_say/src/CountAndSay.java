package com.winner;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        String result = "1";
       if(n == 1){
           return result;
       }
       for (int i = 2; i<=n ; i++){
           result = doCountAndSay(result);
       }
       return result;
    }

    private static String doCountAndSay(String s){
        char[] chars = s.toCharArray();
        int count = 1;
        char tmp = chars[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (tmp == chars[i]) {
                count++;
            } else {
                sb.append(count).append(tmp);
                tmp = chars[i];
                count = 1;
            }
        }
        sb.append(count).append(tmp);
        return sb.toString();
    }

    public static void main(String[] args) {
        countAndSay(6);
    }


}
