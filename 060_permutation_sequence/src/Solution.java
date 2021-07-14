package com.winner.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 60 - 排列序列
 **/
//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 递归 数学 
// 👍 542 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private String res;
    private Integer times = 0;
    boolean[] used ;

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtrack(nums, k, new LinkedList<>());

        return res;
    }

    private void backtrack(int[] nums, int k, LinkedList<String> path) {
        if (res != null) {
            return;
        }

        if (path.size() == nums.length) {
            times++;
            if (k == times) {
                res = String.join("", path);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.add(String.valueOf(nums[i]));
            backtrack(nums, k, path);
            path.removeLast();
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
