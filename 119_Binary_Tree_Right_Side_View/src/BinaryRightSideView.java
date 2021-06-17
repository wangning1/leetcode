package com.winner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 返回二叉树的右视图
 */
public class BinaryRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int queueLen = queue.size();
            for (int i = 0; i < queueLen; i++) {
                TreeNode node = queue.poll();
                if (i == queueLen - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);

        BinaryRightSideView binaryRightSideView = new BinaryRightSideView();
        List<Integer> result = binaryRightSideView.rightSideView(root);
        System.out.println(result);
    }

}
