import java.util.Arrays;

/**
 * @authour winner
 * @Date 2020/5/12 22:50
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int firstOccur = firstOccurIndex(nums, target);
        int lastOccur = lastOccurIndex(nums, target);

        return new int[]{firstOccur, lastOccur};
    }

    private int firstOccurIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    private int lastOccurIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(nums, 6)));
    }

}
