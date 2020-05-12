/**
 * @Description:
 * @CreateDate: 2020/4/21 12:46
 * @Author: wangning
 */
public class Solution {
    public int climbStairs(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    /**
     * 递归求解
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    /**
     * 记忆化递归
     *
     * @param n
     * @return
     */
    public int climibStairs3(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        climbing(n, result);
        return result[n];
    }

    public int climbing(int n, int[] result) {
        if (result[n] > 0) {
            return result[n];
        }
        result[n] = climbing(n - 1, result) + climbing(n - 2, result);
        return result[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));


        System.out.println(solution.climbStairs2(1));
        System.out.println(solution.climbStairs2(2));
        System.out.println(solution.climbStairs2(3));

        System.out.println(solution.climibStairs3(1));
        System.out.println(solution.climibStairs3(2));
        System.out.println(solution.climibStairs3(3));
    }
}
