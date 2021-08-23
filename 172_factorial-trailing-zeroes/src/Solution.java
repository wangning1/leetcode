package com.winner.leetcode.editor.cn;
/**
* 172 - 阶乘后的零
**/
//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        int div = 5;
        while (div <= n){
            res += n / div;
            div *= 5;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
