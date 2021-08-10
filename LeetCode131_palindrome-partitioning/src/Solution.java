package com.winner.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* 131 - 分割回文串
**/
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 

class Solution {
    int[][] f;
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        int n = s.length();
        f = new int[n][n];
        res = new ArrayList<>();
        backtrack(s, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(String s, int i, LinkedList<String> path){
        if(i == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < s.length() ; j++){
            if(isPalindrome(s, i, j) == 1){
                path.add(s.substring(i, j + 1));
                backtrack(s, j + 1, path);
                path.removeLast();
            }
        }
    }

    private int isPalindrome(String s, int i, int j){
        if(f[i][j] != 0){
            return f[i][j];
        }
        if(i >= j){
            f[i][j] = 1;
        }else if(s.charAt(i) == s.charAt(j)){
            f[i][j] = isPalindrome(s, i + 1, j -1);
        }else {
            f[i][j] = -1;
        }
        return f[i][j];
    }

}
