/**
 * @Description:
 * @CreateDate: 2020/4/7 22:53
 * @Author: wangning
 */
public class Solution {
    public static double myPow(double x, int n) {
        if (x == 0 && n != 0) {
            return 0;
        }
        if (x == 0 && n == 0) {
            throw new IllegalArgumentException("error");
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        }
        return myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
    }
}
