package com.winner.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 698 - 划分为k个相等的子集
 **/
//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 示例 1： 
//
// 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 
// 👍 379 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) return false;
        int target = sum / k;

        //以桶视角，一个桶一个桶的装，
        //记录第i个元素是否被使用
        boolean[] used = new boolean[nums.length];
        return backtrackInBucket(nums, k, 0, 0, used, target);

//        //以数字视角
//        int[] bucket = new int[k];
//        //进行优化
//        Arrays.sort(nums);
//        int i = 0;
//        int j = nums.length - 1;
//        while (i < j) {
//            int temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//            i++;
//            j--;
//        }
//        return backtrack(nums, 0, bucket, target);
    }

    //解题思路二：以桶视角
    private boolean backtrackInBucket(int[] nums, int k, int bucket, int start, boolean[] used, int target) {
        if (k == 0) {
            return true;
        }

        if (bucket == target) {
            return backtrackInBucket(nums, k - 1, 0, 0, used, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (bucket + nums[i] > target) {
                continue;
            }

            bucket += nums[i];
            used[i] = true;

            if (backtrackInBucket(nums, k, bucket, i + 1, used, target)) {
                return true;
            }

            bucket -= nums[i];
            used[i] = false;
        }
        return false;
    }


    //解题思路一：以数字视角
    private boolean backtrack(int[] nums, int index, int[] bucket, int target) {
        if (index == nums.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (nums[index] + bucket[i] > target) {
                continue;
            }
            //做出选择
            bucket[i] += nums[index];
            if (backtrack(nums, index + 1, bucket, target)) {
                return true;
            }
            //撤销选择
            bucket[i] -= nums[index];
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
