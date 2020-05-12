import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @CreateDate: 2020/4/17 12:31
 * @Author: wangning
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == word.charAt(0)) {
                    dfs(board, word, visited, i, j, 0, result);
                    if(!result.isEmpty()){
                        return true;
                    }
                }
            }
        }
        return !result.isEmpty();
    }

    private void dfs(char[][] board, String word, boolean[][] visited, int i, int j, int level, List<String>  result) {
        if(!result.isEmpty()){
            return;
        }

        if (level == word.length()) {
            result.add(word);
            return;
        }
        char c = word.charAt(level);
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (board[i][j] != c) {
            return;
        }
        visited[i][j] = true;
        dfs(board, word, visited, i + 1, j, level + 1, result);
        dfs(board, word, visited, i - 1, j, level + 1, result);
        dfs(board, word, visited, i, j + 1, level + 1, result);
        dfs(board, word, visited, i, j - 1, level + 1, result);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(board, "SEE"));
        System.out.println(solution.exist(board, "ABCCED"));
        System.out.println(solution.exist(board, "ABCB"));
    }
}
