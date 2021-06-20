package com.winner;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * <p>
 * 3
 * 9    20
 * 15  7
 */
public class BuildBinaryTreeWithInAndAfterOrder {
    int[] inorder;
    int[] postorder;

    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    Map<Integer, Integer> postorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }

        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        for (int i = 0; i < postorder.length; i++) {
            postorderIndexMap.put(postorder[i], i);
        }
        return doBuild(0, inorder.length - 1, postorder[postorder.length - 1]);
    }

    private TreeNode doBuild(int begin, int end, int root) {
        if (begin > end) {
            return null;
        }

        TreeNode treeNode = new TreeNode(root);
        int inorderRootIndex = inorderIndexMap.get(root);
        int rightRootIndex = postorderIndexMap.get(root) - 1;
        //减去右子树的个数
        int leftRootIndex = postorderIndexMap.get(root) - (end - inorderRootIndex) - 1;

        if (rightRootIndex < 0) {
            return treeNode;
        } else {
            treeNode.right = doBuild(inorderRootIndex + 1, end, postorder[rightRootIndex]);
        }

        if (leftRootIndex < 0) {
            return treeNode;
        } else {
            treeNode.left = doBuild(begin, inorderRootIndex - 1, postorder[leftRootIndex]);
        }

        return treeNode;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
//        int[] inorder = new int[]{1,2};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
//        int[] postorder = new int[]{2,1};


        BuildBinaryTreeWithInAndAfterOrder buildBinaryTreeWithInAndAfterOrder = new BuildBinaryTreeWithInAndAfterOrder();
        TreeNode treeNode = buildBinaryTreeWithInAndAfterOrder.buildTree(inorder, postorder);

        TreeNode.inOrderPrintTree(treeNode);
    }
}
