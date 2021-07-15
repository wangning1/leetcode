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
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 
// 👍 617 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res;
    List<List<String>> splitNums;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if(s == null || s.isEmpty()){
            return res;
        }

        if(s.length() > 12){
            return res;
        }
        char[] arr = s.toCharArray();
        for (char c : arr){
            if(c < '0' || c > '9'){
                return res;
            }
        }
        splitNums = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        backtrack(s, 0, path, 0);
        for (List<String> stringList : splitNums){
            res.add(convertList2Ip(stringList));
        }

        return res;
    }

    private String convertList2Ip(List<String> list){
        StringBuilder sb = new StringBuilder();
        for (String str : list){
            sb.append(str).append(".");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    private void backtrack(String s, int start, LinkedList<String> path, int n){
        if(n == s.length() && path.size() == 4){
            splitNums.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++){
            //每次选择的个数
            for (int j = 1; j <= 3; j++){
                if(path.size() >= 4){
                    continue;
                }
                if(i + j > s.length()){
                    continue;
                }
                //非首位前导不能为0
                String numStart = s.substring(i, i+ 1);
                if( "0".equals(numStart) && j > 1){
                    continue;
                }

                String numStr = s.substring(i, i + j);
                if(Integer.valueOf(numStr) > 255){
                    continue;
                }
                n += j;
                path.add(numStr);
                backtrack(s, i + j, path, n);
                n -= j;
                path.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
