package com.winner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths2(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }

        List<String> allPath = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        doDfs(root, queue, allPath);
        return allPath;
    }

    private void doDfs(TreeNode root, LinkedList<String> queue, List<String> res){
        if(root == null){
            return;
        }

        queue.addLast(Integer.toString(root.val));
        if(root.left == null && root.right == null){
            res.add(String.join("",queue));
        }else {
            queue.addLast("->");
            doDfs(root.left, queue, res);
            doDfs(root.right, queue, res);
            queue.removeLast();
        }
        queue.removeLast();

    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            dfs(root.left, sb.toString(), res);
            dfs(root.right, sb.toString(), res);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> res = binaryTreePaths.binaryTreePaths2(root);
        System.out.println(res);
    }

}
