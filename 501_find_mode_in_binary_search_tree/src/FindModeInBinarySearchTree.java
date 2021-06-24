package com.winner;

import java.util.*;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 */
public class FindModeInBinarySearchTree {
    int base;
    int count;
    int maxCount;
    List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int val){
        if(val == base){
            ++count;
        }else {
            base = val;
            count = 1;
        }

        if(maxCount == count){
            res.add(val);
        }
        if(count > maxCount){
            maxCount = count;
            res.clear();
            res.add(val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(2);
        FindModeInBinarySearchTree findModeInBinarySearchTree = new FindModeInBinarySearchTree();
        System.out.println(Arrays.toString(findModeInBinarySearchTree.findMode(root)));
    }


}
