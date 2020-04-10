import java.util.Arrays;

/**
 * @Description:
 * @CreateDate: 2020/4/9 16:51
 * @Author: wangning
 */
public class Solution {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 3};
        System.out.println(majorityElement(nums));
    }
}
