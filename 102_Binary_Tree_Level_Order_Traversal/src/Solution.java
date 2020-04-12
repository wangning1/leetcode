import java.util.*;

/**
 * @authour winner
 * @Date 2020/4/12 15:07
 */
public class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    /**
     * dfs遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, 0, map);
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private static void dfs(TreeNode node, Integer level, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }
        List<Integer> levelList;
        if (map.get(level) == null) {
            levelList = new ArrayList<>();
            map.put(level, levelList);
        } else {
            levelList = map.get(level);
        }

        levelList.add(node.val);
        dfs(node.left, level + 1, map);
        dfs(node.right, level + 1, map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
        System.out.println(levelOrder2(root));
    }

}
