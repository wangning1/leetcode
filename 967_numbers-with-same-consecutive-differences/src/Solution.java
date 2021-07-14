//返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。 
//
// 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 7
//输出：[181,292,707,818,929]
//解释：注意，070 不是一个有效的数字，因为它有前导零。
// 
//
// 示例 2： 
//
// 
//输入：n = 2, k = 1
//输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98] 
//
// 示例 3： 
//
// 
//输入：n = 2, k = 0
//输出：[11,22,33,44,55,66,77,88,99]
// 
//
// 示例 4： 
//
// 
//输入：n = 2, k = 2
//输出：[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 9 
// 0 <= k <= 9 
// 
// Related Topics 广度优先搜索 回溯 
// 👍 56 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    public int[] numsSameConsecDiff(int n, int k) {
        if (n <= 0) {
            return new int[]{};
        }

        res = new ArrayList<>();
        backtrack(n, k, new LinkedList<>());

        int[] ans = new int[res.size()];
        int i = 0;
        for (List<Integer> integerList : res) {
            int num = 0;
            for (Integer integer : integerList) {
                num = num * 10 + integer;
            }
            ans[i] = num;
            i++;
        }
        return ans;
    }

    private void backtrack(int n, int k, LinkedList<Integer> path) {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i <= 9; i++) {
            int pathSize = path.size();
            if (pathSize == 0 && i == 0) {
                continue;
            }

            if (pathSize >= 1 && (Math.abs(i - path.get(pathSize - 1)) != k)) {
                continue;
            }

            path.add(i);
            backtrack(n, k, path);
            path.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
