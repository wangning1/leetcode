package com.winner;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryPathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        doAddPath(root, targetSum, path, res);
        return res;
    }

    public void doAddPath(TreeNode treeNode, int targetSum, Deque<Integer> path,List<List<Integer>> res){
        if(treeNode == null){
            return;
        }

        path.offerLast(treeNode.val);
        if(treeNode.left == null && treeNode.right == null){
            if(treeNode.val == targetSum){
                res.add(new ArrayList<>(path));
            }
        }
        doAddPath(treeNode.left, targetSum - treeNode.val,  path, res);
        doAddPath(treeNode.right, targetSum - treeNode.val,  path, res);
        path.pollLast();
    }

    public static void main(String[] args) {
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(4);
            root.right = new TreeNode(8);
            root.left.left = new TreeNode(11);
            root.right.left = new TreeNode(13);
            root.right.right = new TreeNode(4);
            root.left.left.left = new TreeNode(7);
            root.left.left.right = new TreeNode(2);
            root.right.right.left = new TreeNode(5);
            root.right.right.right =new TreeNode(1);

            BinaryPathSumII binaryPathSumII = new BinaryPathSumII();
            List<List<Integer>> res = binaryPathSumII.pathSum(root, 22);
        System.out.println(res);
    }


}
