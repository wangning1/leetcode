import java.util.Arrays;

/**
 * @Description:
 * @CreateDate: 2020/4/20 12:51
 * @Author: wangning
 */
public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        if (num == 0) {
            result[0] = 0;
        }
        if (num >= 1) {
            result[0] = 0;
            result[1] = 1;
            for (int i = 2; i <= num; i++) {
                result[i] = result[i & (i - 1)] + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countBits(2)));
        System.out.println(Arrays.toString(solution.countBits(5)));
    }


}
