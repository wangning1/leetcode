package com.winner.leetcode.editor.cn;

import java.util.*;

/**
 * 491 - 递增子序列
 **/
//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
// Related Topics 位运算 数组 哈希表 回溯 
// 👍 328 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    boolean[] visited;

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        visited = new boolean[nums.length];
        if (nums == null || nums.length <= 0) {
            return res;
        }

        for (int len = 2; len <= nums.length; len++) {
            backtrack(nums, 0, len, new LinkedList<>());
        }

        return res;
    }

    private void backtrack(int[] nums, int startIndex, int len, LinkedList<Integer> path) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {

            //同一层已经使用过，不再使用
            if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);

//            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) {
//                continue;
//            }

            if (path.size() > 0 && path.get(path.size() - 1) > nums[i]) {
                continue;
            }


            visited[i] = true;
            path.add(nums[i]);
            backtrack(nums, i + 1, len, path);
            path.removeLast();
            visited[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
