package com.winner;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void preOrderPrintTree(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrderPrintTree(root.left);
        preOrderPrintTree(root.right);
    }

    public static void inOrderPrintTree(TreeNode root){
        if(root == null){
            return;
        }
        inOrderPrintTree(root.left);
        System.out.println(root.val);
        inOrderPrintTree(root.right);
    }

    public static void postOrderPrintTree(TreeNode root){
        if(root == null){
            return;
        }
        postOrderPrintTree(root.left);
        postOrderPrintTree(root.right);
        System.out.println(root.val);
    }
}
