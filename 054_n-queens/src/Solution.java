package com.winner.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 51 - N 皇后
 **/
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, 0);
        return res;
    }

    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(wrapBorad(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }

            board[row][i] = 'Q';
            backtrack(board, row + 1);
            board[row][i] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        //检查列上是否冲突
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //检查左上方是否冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //检查右上方是否冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> wrapBorad(char[][] board) {
        List<String> boardStr = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String str = new String(board[i]);
            boardStr.add(str);
        }
        return boardStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
