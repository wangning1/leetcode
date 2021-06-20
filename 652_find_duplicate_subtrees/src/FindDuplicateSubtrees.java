package com.winner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 */
public class FindDuplicateSubtrees {

    Map<String, Integer> duplicateMap;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        duplicateMap = new HashMap<>();
        res = new ArrayList<>();
        doCaculate(root);
        return res;
    }

    private String doCaculate(TreeNode node){
        if(node == null){
            return "#";
        }
        String nodeStr = node.val + "," + doCaculate(node.left) + "," + doCaculate(node.right);
        duplicateMap.put(nodeStr, duplicateMap.getOrDefault(nodeStr, 0) + 1);
        if(duplicateMap.get(nodeStr) == 2){
            res.add(node);
        }
        return nodeStr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
        List<TreeNode> res =  findDuplicateSubtrees.findDuplicateSubtrees(root);

        for (TreeNode treeNode: res){
            TreeNode.preOrderPrintTree(treeNode);
            System.out.println();
        }
    }
}
