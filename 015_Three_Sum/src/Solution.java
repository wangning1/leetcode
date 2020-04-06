import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @CreateDate: 2020/4/5 21:37
 * @Author: wangning
 */
public class Solution {
    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        //首先将数组排序
        Arrays.sort(nums);
        //单次遍历，前后夹击
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int bIndex = i + 1;
            int cIndex = nums.length - 1;
            while (bIndex < cIndex) {
                int b = nums[bIndex];
                int c = nums[cIndex];
                if (a + b + c > 0) {
                    //重复元素直接跳过
                    if (nums[cIndex--] == c) {
                        continue;
                    }
                } else if (a + b + c < 0) {
                    //重复元素直接跳过
                    if (nums[bIndex++] == b) {
                        continue;
                    }
                } else {
                    List<Integer> solution = new ArrayList<>();
                    solution.add(a);
                    solution.add(b);
                    solution.add(c);

                    if (!result.contains(solution)) {
                        result.add(solution);
                    }

                    while (nums[++bIndex] == b && bIndex < nums.length - 1) {
                        //跳过本次相同元素
                    }
                    while (nums[--cIndex] == c && cIndex > 1) {
                        //跳过本次相同元素
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                numMap.put(nums[i], numMap.get(nums[i]) + 1);
            } else {
                numMap.put(nums[i], 1);
            }
        }


        List<List<Integer>> reult = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];

            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];

                int c = -(nums[i] + nums[j]);
                if (numMap.containsKey(c)) {
                    if (c == a && numMap.get(a) == 1) {
                        continue;
                    }
                    if (c == b && numMap.get(b) == 1) {
                        continue;
                    }
                    if (a == b && b == c && numMap.get(a) < 3) {
                        continue;
                    }
                    List<Integer> solution = new ArrayList<>();

                    solution.add(a);
                    solution.add(b);
                    solution.add(c);
                    Collections.sort(solution);
                    if (!reult.contains(solution)) {
                        reult.add(solution);
                    }
                }
            }
        }

        return reult;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,1,1,2
        };
        System.out.println(threeSum2(nums));
    }
}
