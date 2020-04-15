/**
 * @Description:
 * @CreateDate: 2020/4/15 11:53
 * @Author: wangning
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValidSudoku(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //判断新加入元素的有效性
    public boolean isValidSudoku(char[][] board, int row, int col, char c) {
        for (int k = 0; k < 9; k++) {
            //判断行
            if (k != row && board[k][col] == c) {
                return false;
            }

            //判断列
            if (k != col && board[row][k] == c) {
                return false;
            }
            //判断3*3矩阵
            if ((3 * (row / 3) + k / 3) != row
                    && (3 * (col / 3) + k % 3) != col && board[3 * (row / 3) + k / 3][3 * (col / 3) + k % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    //判断3*3矩阵
                    for (int k = 0; k < 9; k++) {
                        //判断行
                        if (k != i && board[k][j] == c) {
                            return false;
                        }

                        //判断列
                        if (k != j && board[i][k] == c) {
                            return false;
                        }

                        if ((3 * (i / 3) + k / 3) != i && (3 * (j / 3) + k % 3) != j && board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] boards = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(boards));
        solution.solveSudoku(boards);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(" " + boards[i][j]);
            }
            System.out.println();
        }
    }
}
