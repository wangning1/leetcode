import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @CreateDate: 2020/4/4 11:21
 * @Author: wangning
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, 9)));
        System.out.println(Arrays.toString(solution.twoSum2(nums, 9)));
    }

    /**
     * 暴力破解，执行时间过长
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     *通过空间换时间的方式，只遍历一次
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]), i};
            }
            result.put(nums[i], i);

        }
        throw new IllegalArgumentException("no result");
    }

}
