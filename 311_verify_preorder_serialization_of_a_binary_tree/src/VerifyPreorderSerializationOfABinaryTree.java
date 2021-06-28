package com.winner;

public class VerifyPreorderSerializationOfABinaryTree {
    int index;
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) {
            return false;
        }
        index = -1;
        String[] nodes = preorder.split(",");
        dfs(nodes);
        return index == nodes.length - 1;
    }

    private void dfs(String[] preorder) {
        index++;
        System.out.println(index);
        if (index >= preorder.length) {
            return;
        }

        if (preorder[index].equals("#")) return;
        dfs(preorder);
        dfs(preorder);
    }

    public static void main(String[] args) {
        String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        VerifyPreorderSerializationOfABinaryTree verifyPreorderSerializationOfABinaryTree = new VerifyPreorderSerializationOfABinaryTree();
        System.out.println(verifyPreorderSerializationOfABinaryTree.isValidSerialization(str));
    }

}
