package com.winner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 前序遍历二叉树
 */
public class PreOrderTraversalTree {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        doPreOrderTraversal(root, result);
        return result;
    }

    private void doPreOrderTraversal(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }
        result.add(node.val);
        doPreOrderTraversal(node.left, result);
        doPreOrderTraversal(node.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        PreOrderTraversalTree preOrderTraversalTree = new PreOrderTraversalTree();
        List<Integer> result = preOrderTraversalTree.preorderTraversal(root);
        System.out.println(Arrays.toString(result.toArray()));
    }

}
