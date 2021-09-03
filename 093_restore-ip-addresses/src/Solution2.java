package com.winner.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 93 - 复原 IP 地址
 **/
//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 


//leetcode submit region begin(Prohibit modification and deletion)
class Solution93 {
    List<List<String>> res;

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        List<String> ipRes = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return ipRes;
        }

        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                return ipRes;
            }
        }

        backtrack(s, 0, new LinkedList<>());
        System.out.println(res);
        for (List<String> stringList : res) {
            ipRes.add(String.join(".", stringList));
        }
        return ipRes;
    }

    private void backtrack(String s, int startIndex, LinkedList<String> path) {
        if (startIndex >= s.length() && path.size() == 4) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (path.size() > 4) {
            return;
        }

        for (int j = 1; j <= 3; j++) {
            if (startIndex + j > s.length()) {
                continue;
            }

            String str = s.substring(startIndex, startIndex + j);
            if (j > 1 && str.charAt(0) == '0') {
                continue;
            }

            if (Integer.valueOf(str) > 255) {
                continue;
            }

            path.add(str);
            backtrack(s, startIndex + j, path);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
