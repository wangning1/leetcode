/**
 * @Description:
 * @CreateDate: 2020/4/10 15:21
 * @Author: wangning
 */
public class Solution {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(nums));
    }
}
