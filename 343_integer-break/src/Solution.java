package com.winner.leetcode.editor.cn;
/**
* 343 - 整数拆分
**/
//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++){
            for (int j = 1; j < i; j++){
                dp[i] = Math.max(Math.max(dp[i], j * (i-j)), dp[j] * (i-j));
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
