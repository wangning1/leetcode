package com.winner;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        preTraversal(root, treeNodeList);
        int i = 0;
        for (; i < treeNodeList.size() - 1; i++){
            treeNodeList.get(i).left = null;
            treeNodeList.get(i).right = treeNodeList.get(i + 1);
        }
    }

    void preTraversal(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        preTraversal(root.left, list);
        preTraversal(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
        flattenBinaryTree.flatten(root);
        TreeNode.preOrderPrintTree(root);
    }
}
