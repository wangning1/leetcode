package com.winner;

/**
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 计算给定二叉树的所有左叶子之和。
 */
public class SumOfLeftLeaves {

    int leftLeavesSum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return leftLeavesSum;
        }

        doCaculateLeft(root);
        return leftLeavesSum;
    }

    private void doCaculateLeft(TreeNode node) {
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                leftLeavesSum += node.left.val;
            } else {
                doCaculateLeft(node.left);
            }
        }
        if (node.right != null) {
            doCaculateLeft(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        sumOfLeftLeaves.sumOfLeftLeaves(root);
        System.out.println(sumOfLeftLeaves.leftLeavesSum);
    }
}
