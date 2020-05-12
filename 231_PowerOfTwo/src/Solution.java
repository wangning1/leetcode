/**
 * @Description:
 * @CreateDate: 2020/4/20 12:37
 * @Author: wangning
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        if((n & (n-1)) == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(1));
        System.out.println(solution.isPowerOfTwo(16));
        System.out.println(solution.isPowerOfTwo(218));
    }
}
