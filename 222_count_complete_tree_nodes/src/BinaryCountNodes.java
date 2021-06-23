package com.winner;

public class BinaryCountNodes {

    /**
     * 常规解法
     *
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }

    /**
     * 利用完全二叉树的特点
     */

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeLevel(root.left);
        int right = treeLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    private int treeLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level += 1;
            root = root.left;
        }
        return level;
    }


}
