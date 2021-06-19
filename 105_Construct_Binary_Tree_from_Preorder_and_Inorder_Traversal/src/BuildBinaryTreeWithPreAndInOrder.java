package com.winner;

import com.winner.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据前序和中序序列构造树
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
class BuildBinaryTreeWithPreAndInOrder {
    int[] preoder;
    int[] inorder;
    Map<Integer, Integer> preOrderIndexMap = new HashMap<>();
    Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        this.preoder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < preorder.length; i++) {
            preOrderIndexMap.put(preorder[i], i);
        }
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return doBuild(0, inorder.length - 1, preorder[0]);
    }

    private TreeNode doBuild(int begin, int end, int root) {
        if (begin > end) {
            return null;
        }
        TreeNode rootNode = new TreeNode(root);
        //中序中找到根的下标，将二叉树一分为二
        int inOderRootIndex = inOrderIndexMap.get(root);
        //在先序中找到左树的根（先序根的下标加1）
        int preOrderRootIndex = preOrderIndexMap.get(root);
        int leftRootIndex = preOrderRootIndex + 1;
        //在先序中找到右树的根（先序根的下标加上左树的个数）
        int rightRootIndex = preOrderRootIndex + (inOderRootIndex - begin) + 1;
        if(leftRootIndex >= preoder.length){
            return rootNode;
        }else {
            rootNode.left = doBuild(begin, inOderRootIndex - 1, preoder[leftRootIndex]);
        }
        if(rightRootIndex >= inorder.length){
            return rootNode;
        }else {
            rootNode.right = doBuild(inOderRootIndex + 1, end, preoder[rightRootIndex]);
        }

        return rootNode;
    }

    public static void main(String[] args) {
//        int[] preOrder = new int[]{1,2};
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
//        int[] inOrder = new int[]{2,1};

        BuildBinaryTreeWithPreAndInOrder buildBinaryTreeWithPreAndInOrder = new BuildBinaryTreeWithPreAndInOrder();
        TreeNode root = buildBinaryTreeWithPreAndInOrder.buildTree(preOrder, inOrder);
        TreeNode.inOrderPrintTree(root);
    }

}
