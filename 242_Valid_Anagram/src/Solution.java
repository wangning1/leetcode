/**
 * @Description:
 * @CreateDate: 2020/4/5 21:09
 * @Author: wangning
 */
public class Solution {
    public static boolean isAnagram(String s, String t) {
        if (s == t) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for (int i = 0; i < sCharArr.length; i++) {
            sCount[sCharArr[i] - 'a'] = sCount[sCharArr[i] - 'a'] + 1;
        }

        for (int i = 0; i < tCharArr.length; i++) {
            tCount[tCharArr[i] - 'a'] = tCount[tCharArr[i] - 'a'] + 1;
        }
        for (int i = 0; i < 26; i++) {
            if(sCount[i] != tCount[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

}
