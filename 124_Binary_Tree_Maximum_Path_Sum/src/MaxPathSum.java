package com.winner;

/**
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class MaxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        oneSidePath(root);
        return max;
    }

    public int oneSidePath(TreeNode node) {
        if(node == null){
            return 0;
        }
        int maxLeft = Math.max(0, oneSidePath(node.left));
        int maxRight = Math.max(0, oneSidePath(node.right));
        max = Math.max(max, maxLeft + maxRight + node.val);
        return Math.max(maxLeft, maxRight) + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(root));
    }
}
