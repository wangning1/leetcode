package com.winner;

public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return root;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);

        ConvertBSTtoGreaterTree convertBSTtoGreaterTree = new ConvertBSTtoGreaterTree();
        root = convertBSTtoGreaterTree.convertBST(root);
        TreeNode.preOrderPrintTree(root);
    }
}
