package com.winner;

/**
 *给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。a
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(val > root.val){
            root.right = insertIntoBST(root.right, val);
        }else if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }


}
