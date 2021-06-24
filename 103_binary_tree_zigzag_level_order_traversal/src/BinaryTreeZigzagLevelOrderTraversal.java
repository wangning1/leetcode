package com.winner;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        int i = 1;
        //奇数用队列，偶数用栈
        while (!queue.isEmpty() || !stack.isEmpty()){
            List<Integer> levelRes = new ArrayList<>();
            if(i % 2 != 0){
                int queueLen = queue.size();
                for (int j = 0; j< queueLen; j++){
                    TreeNode node = queue.removeFirst();
                    levelRes.add(node.val);
                    if(node.left != null){
                        stack.push(node.left);
                    }
                    if(node.right != null){
                        stack.push(node.right);
                    }
                }
            }else {
                int stackLen = stack.size();
                for (int k = 0; k < stackLen; k++){
                    TreeNode node = stack.pop();
                    levelRes.add(node.val);

                    if(node.right != null){
                        queue.addFirst(node.right);
                    }

                    if(node.left != null){
                        queue.addFirst(node.left);
                    }

                }
            }
            res.add(levelRes);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
//
        BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> res = binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(root);
        System.out.println(res);
    }
}
