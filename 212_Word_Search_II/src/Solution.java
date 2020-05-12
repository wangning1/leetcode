import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @CreateDate: 2020/4/17 17:42
 * @Author: wangning
 */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        if (board == null || words == null) {
            return new ArrayList<>();
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int rowLen = board.length;
        int colLen = board[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                dfs(board, visited, i, j, "", trie, result);
            }
        }
        return new ArrayList<>(result);
    }

    public void dfs(char[][] board, boolean[][] visited, int i, int j, String word, Trie trie, Set<String> result) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        word += board[i][j];
        if (!trie.startsWith(word)) {
            return;
        }

        if (trie.search(word)) {
            result.add(word);
        }

        visited[i][j] = true;
        dfs(board, visited, i - 1, j, word, trie, result);
        dfs(board, visited, i + 1, j, word, trie, result);
        dfs(board, visited, i, j - 1, word, trie, result);
        dfs(board, visited, i, j + 1, word, trie, result);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = new String[]{"oath", "pea", "eat", "rain"};

        Solution solution = new Solution();
        List result = solution.findWords(board, words);
        System.out.println(result);
    }
}

class Trie {
    public TreeNode root;

    public Trie() {
        root = new TreeNode(' ');
    }

    public void insert(String word) {
        TreeNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TreeNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        TreeNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}

class TreeNode {
    public char val;
    public boolean isWord;
    public TreeNode[] children = new TreeNode[26];

    public TreeNode() {
    }

    TreeNode(char c) {
        TreeNode node = new TreeNode();
        node.val = c;
    }
}
