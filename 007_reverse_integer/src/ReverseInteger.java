package com.winner;

/**
 *给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。

 */
public class ReverseInteger {
    public static int reverse(int x) {
        long result = 0;
        while (x != 0){
            int tmp = x % 10;
            result = result * 10 + tmp;
            x = x / 10;
        }
        return (int)result == result ? (int)result : 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }
}
