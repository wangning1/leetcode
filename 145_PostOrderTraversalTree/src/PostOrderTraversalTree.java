package com.winner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二叉树的后序遍历
 */
public class PostOrderTraversalTree {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        doPostOrderTraversal(root, result);
        return result;
    }

    private void doPostOrderTraversal(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }
        doPostOrderTraversal(node.left, result);
        doPostOrderTraversal(node.right, result);
        result.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        PostOrderTraversalTree postOrderTraversalTree = new PostOrderTraversalTree();
        List result = postOrderTraversalTree.postorderTraversal(root);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
