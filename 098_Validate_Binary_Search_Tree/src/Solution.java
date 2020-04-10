import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @CreateDate: 2020/4/6 10:30
 * @Author: wangning
 */
public class Solution {

    /**
     * 递归的方式
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, null, null);
    }

    boolean isValidNode(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && min >= node.val) {
            return false;
        }
        if (max != null && max <= node.val) {
            return false;
        }
        return isValidNode(node.left, min, node.val) && isValidNode(node.right, node.val, max);
    }

    /**
     * 中序遍历的方式
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) >= result.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root, List<Integer> resultList) {
        if (root.left != null) {
            inOrder(root.left, resultList);
        }

        resultList.add(root.val);

        if (root.right != null) {
            inOrder(root.right, resultList);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        List<Integer> inOrderList = new ArrayList<>();

        Solution solution = new Solution();
        solution.inOrder(root, inOrderList);
        System.out.println(inOrderList);
        System.out.println(solution.isValidBST(root));
        System.out.println(solution.isValidBST2(root));
    }
}
