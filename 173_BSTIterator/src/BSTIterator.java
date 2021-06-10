package com.winner;

import java.util.*;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 *
 *     BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 *     boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 *     int next()将指针向右移动，然后返回指针处的数字。
 *
 */
public class BSTIterator {
    List<TreeNode> list = new ArrayList<>();
    Iterator<TreeNode> iterator;

    public BSTIterator(TreeNode root) {
        if (root != null) {
            doInQueue(root, list);
        }
        iterator = list.iterator();
    }

    private void doInQueue(TreeNode node, List<TreeNode> queue) {
        if (node == null) {
            return;
        }
        doInQueue(node.left, queue);
        queue.add(node);
        doInQueue(node.right, queue);
    }

    public int next() {
        return iterator.next().val;
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        BSTIterator bstIterator = new BSTIterator(root);
        while (bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }
    }
}
