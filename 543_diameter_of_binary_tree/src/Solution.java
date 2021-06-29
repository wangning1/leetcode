package com.winner.leetcode.editor.cn;
/**
 * 543 - 二叉树的直径
 **/
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 729 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int ans = -1;

    public int diameterOfBinaryTree(TreeNode root) {
        //方法一：在求深度的时候直接把结果维护了
        //dfs(root);

        //方法二：求深度和求结果分开处理
        depth(root);
        return ans;
    }

    private int depth(TreeNode node){
        if(node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        ans = Math.max(ans, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        int val = nodeDepth(node.left) + nodeDepth(node.right);
        if (val > ans) {
            ans = val;
        }
        dfs(node.left);
        dfs(node.right);
    }


    private int nodeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(nodeDepth(node.left), nodeDepth(node.right));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
