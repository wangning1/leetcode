/**
 * @Description:
 * @CreateDate: 2020/4/22 12:03
 * @Author: wangning
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int iNum = nums[i];
            dp[i][0] = iNum >= 0 ? Math.max(dp[i - 1][0] * iNum, iNum) : Math.max(dp[i - 1][1] * iNum, iNum);
            dp[i][1] = iNum >= 0 ? Math.min(dp[i - 1][1] * iNum, iNum) : Math.min(dp[i - 1][0] * iNum, iNum);
            if (dp[i][0] >= result) {
                result = dp[i][0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(nums));
        int[] nums2 = new int[]{-2, 0, -1};
        System.out.println(solution.maxProduct(nums2));

        int[] nums3 = new int[]{2, 3, -1, 5, 4, -2};
        System.out.println(solution.maxProduct(nums3));
    }

}
