//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 



import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (k > n) {
            return new ArrayList<>();
        }

        LinkedList<Integer> numSet = new LinkedList<>();
        backtrack(numSet, n, k, 1);
        return res;
    }

    private void backtrack(LinkedList<Integer> numSet, int n, int k, int start) {


        if (numSet.size() == k) {
            res.add(new ArrayList<Integer>(numSet));
            return;
        }

        //进行剪枝 不剪枝 i < n
        for (int i = start ; i <= n - (k - numSet.size()) + 1; i++) {
            numSet.addLast(i);
            backtrack(numSet, n, k, i + 1);
            numSet.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
