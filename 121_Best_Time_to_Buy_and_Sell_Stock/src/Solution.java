/**
 * @Description:
 * @CreateDate: 2020/4/10 15:12
 * @Author: wangning
 */
public class Solution {
    public static int maxProfit(int[] prices) {
        Integer minPrice = Integer.MAX_VALUE;
        Integer maxResult = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxResult) {
                maxResult = prices[i] - minPrice;
            }
        }
        return maxResult;
    }
    
    
    //暴力求解
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        int maxProfit = 0;
        //第i天买入，第j天卖出
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(prices[j] - prices[i], maxProfit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(nums));
    }
}
