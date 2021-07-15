package com.winner.leetcode.editor.cn;

/**
 * 200 - 岛屿数量
 **/
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1229 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numIslands(char[][] grid) {
        int islandNum = 0;
        if (grid == null || grid.length == 0) {
            return islandNum;
        }
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int r = 0; r < rowLen; r++) {
            for (int c = 0; c < colLen; c++) {
                if (grid[r][c] == '1') {
                    islandNum++;
                    dfs(grid, r, c);
                }
            }
        }

        return islandNum;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if (r < 0 || c < 0 || r >= rowLen || c >= colLen || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
