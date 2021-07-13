package com.winner.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39 - 组合总和
 **/
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates == null || candidates.length <= 0) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(candidates, target, path, 0, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, LinkedList<Integer> path, int pathSum, int start) {
        //剪枝
        if (pathSum > target) {
            return;
        }
        if (pathSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            pathSum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, path, pathSum, i);
            pathSum -= candidates[i];
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
