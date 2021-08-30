package com.winner.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 17 - 电话号码的字母组合
 **/
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] digit2LetterArr = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()){
            return res;
        }
        backtrack(digits, 0, "");
        return res;
    }

    private void backtrack(String digits, int level, String s) {
        if (level == digits.length()) {
            res.add(s);
            return;
        }

        int digit = digits.charAt(level) - '0';
        String letters = digit2LetterArr[digit];
        for (int i = 0; i < letters.length(); i++) {
            backtrack(digits, level + 1, s + letters.charAt(i));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
