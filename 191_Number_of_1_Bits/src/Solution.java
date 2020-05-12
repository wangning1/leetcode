/**
 * @Description:
 * @CreateDate: 2020/4/17 18:20
 * @Author: wangning
 */
public class Solution {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public int hamingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println();
        System.out.println(solution.hammingWeight(11));
        System.out.println(solution.hamingWeight2(11));

        System.out.println(solution.hammingWeight(8));
        System.out.println(solution.hamingWeight2(8));
    }
}
