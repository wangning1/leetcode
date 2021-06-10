package com.winner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InOrderTraversalTree {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        doInOrderTraversal(root, result);
        return result;
    }

    private void doInOrderTraversal(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }
        doInOrderTraversal(node.left, result);
        result.add(node.val);
        doInOrderTraversal(node.right, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        InOrderTraversalTree inOrderTraversalTree = new InOrderTraversalTree();
        List result = inOrderTraversalTree.inorderTraversal(root);
        System.out.println(Arrays.toString(result.toArray()));
    }

}
