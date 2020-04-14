/**
 * @authour winner
 * @Date 2020/4/12 16:28
 */
public class Solution {
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        return (minLeft == 0 || minRight == 0) ? minLeft + minRight + 1 : 1 + Math.min(minLeft, minRight);
    }

    public static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepth1(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth1(root.left);
        }

        int minLeftDepth = minDepth(root.left);
        int minRightDepth = minDepth1(root.right);

        return 1 + Math.min(minLeftDepth, minRightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));

        System.out.println(minDepth1(root));
    }
}
