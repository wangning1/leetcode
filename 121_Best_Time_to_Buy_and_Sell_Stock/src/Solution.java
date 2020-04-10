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

    public static void main(String[] args) {
        int[] nums = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(nums));
    }
}
