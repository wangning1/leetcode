import java.util.Arrays;

/**
 * @Description:
 * @CreateDate: 2020/4/27 12:25
 * @Author: wangning
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                } else {
                    if (dp[i] == 0) {
                        dp[i] = 1;
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(dp));
        int result = dp[0];
        for (int i = 0; i < nums.length; i++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 10, 3, 4, 8, 9};
//        int[] nums = new int[]{10, 9, 2, 5, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(nums));
    }
}
